package csv.postpaid.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.postpaid.dao.IBSCSDao;
import csv.postpaid.domain.BillingAccount;
import csv.postpaid.domain.Contract;
import csv.postpaid.domain.ContractSearchCriteria;
import csv.postpaid.domain.DirectoryNumber;
import csv.postpaid.domain.Document;
import csv.postpaid.domain.GprsUsage;
import csv.postpaid.domain.IPostpaidAccount;
import csv.postpaid.domain.LargeAccount;
import csv.postpaid.domain.Memo;
import csv.postpaid.domain.Payment;
import csv.postpaid.domain.PaymentArrangement;
import csv.postpaid.domain.PostpaidAccount;
import csv.postpaid.domain.PromotionPackage;
import csv.postpaid.domain.RatePlanChange;
import csv.postpaid.domain.StatusChange;
import csv.postpaid.domain.StorageMediumChange;
import csv.security.domain.OperationNames;

@Stateful
@Name("contractService")
@Scope(ScopeType.CONVERSATION)
public class ContractService extends BaseService implements IContractService {

	private static final long serialVersionUID = 5886137669389589445L;

	@In(required=false, value="currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("bscsDao")
	private IBSCSDao bscsDao;
	
	@In(create=true, value="postpaidService", required=false)
	private IPostpaidService postpaidService;
	
	private ContractSearchCriteria contractSearchCriteria = new ContractSearchCriteria();
	
	private List<IPostpaidAccount> accountList = new ArrayList<IPostpaidAccount>();
	
	private PostpaidAccount selectedAccount;
	
	private Contract selectedContract;
	
	private Memo selectedMemo;
	
	private Long selectedBillAccountId;
	
	public ContractService() {
		super();
	}
	
	public ContractSearchCriteria getContractSearchCriteria() {
		return contractSearchCriteria;
	}

	public void setContractSearchCriteria(ContractSearchCriteria contractSearchCriteria) {
		this.contractSearchCriteria = contractSearchCriteria;
	}
	
	public List<IPostpaidAccount> getAccountList() {
		return accountList;
	}
	
	public PostpaidAccount getSelectedAccount() {
		return selectedAccount;
	}

	public void setSelectedAccount(PostpaidAccount selectedAccount) {
		this.selectedAccount = selectedAccount;
	}
	
	public Contract getSelectedContract() {
		return selectedContract;
	}

	public void setSelectedContract(Contract selectedContract) {
		this.selectedContract = selectedContract;
	}

	@Begin(join=true)
	public void retrieveLargeAccounts() {
		accountList = new ArrayList<IPostpaidAccount>();
		try {
			List<LargeAccount> accounts = bscsDao.findLargeAccounts(contractSearchCriteria.getCustomerCode());
			accountList.addAll(accounts);
			if(accountList.size() == 0) throw new RuntimeException("No Large Accounts found with the given Criteria..");
			contractSearchCriteria = new ContractSearchCriteria();
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void tryInitSearchCriteria() {
		if(currentCustomer != null && currentCustomer.getMsisdn() != null && currentCustomer.getMsisdn().length() != 0) 
			contractSearchCriteria.setMsisdn(currentCustomer.getMsisdn());
	}

	@Begin(join=true)
	public void searchCustomerContracts() {
		accountList = new ArrayList<IPostpaidAccount>();
		try {
			contractSearchCriteria.validate();
			if(contractSearchCriteria.getMsisdn() != null && contractSearchCriteria.getMsisdn().length() != 0) {
				PostpaidAccount acc = findContractFromMSISDN(contractSearchCriteria.getMsisdn());
				accountList.add(acc);
			} else if(contractSearchCriteria.getStorageMediumNo() != null && contractSearchCriteria.getStorageMediumNo().length() != 0 ) {
				PostpaidAccount acc = findContractFromStorageMedium(contractSearchCriteria.getStorageMediumNo());
				accountList.add(acc);
			} else {
				List<PostpaidAccount> acc = bscsDao.findCustomersByCustomerCodeAndName(contractSearchCriteria.getCustomerCode(), contractSearchCriteria.getFirstName(), contractSearchCriteria.getLastName());
				accountList.addAll(acc);
			}
			if(accountList.size() == 0) throw new RuntimeException("No contracts found with the given Criteria..");
			contractSearchCriteria = new ContractSearchCriteria();
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
		
	}
	
	private PostpaidAccount findContractFromCustomerCode(String custCode) {
		PostpaidAccount acc = bscsDao.findCustomerByCustomerCode(custCode);
		if(acc == null) throw new RuntimeException("Contract could not be found for Customer Code: " + custCode);
		return acc;
	}
	
	private PostpaidAccount findContractFromMSISDN(String msisdn) {
		String custCode = bscsDao.findCustomerCodeFromMSISDN("258" + msisdn);
		if(custCode == null) throw new RuntimeException("Customer Code could not be found for MSISDN: " + msisdn);
		return findContractFromCustomerCode(custCode);
	}
	
	private PostpaidAccount findContractFromStorageMedium(String storageMediumNo) {
		String custCode = bscsDao.findCustomerCodeFromStorageMedium(storageMediumNo);
		if(custCode == null) throw new RuntimeException("Customer Code could not be found for Storage Medium: " + storageMediumNo);
		return findContractFromCustomerCode(custCode);
	}

	@Override
	public void viewAccountDetails(IPostpaidAccount account) {
		try {
			PostpaidAccount acc = bscsDao.findCustomerByCustomerCode(account.getCustomerCode());
			if(acc == null) throw new RuntimeException("Customer Details cannot be found for the Customer Code: " + account.getCustomerCode());
			selectedAccount = acc;
			acc.setCustomerCode(account.getCustomerCode());
			acc.setContracts(bscsDao.findContractsByCustomerCode(acc.getCustomerCode()));
			List<BillingAccount> billingAccounts = bscsDao.findBillingAccounts(acc.getCustomerId().toString());
			acc.setBillingAccounts(billingAccounts);
			logAccess(OperationNames.PostpaidContractEnquiry, currentCustomer.getFullMsisdn(), acc.getCustomerCode(), acc.getCustomerId(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	@Override
	public void viewPaymentArrangement() {
		try {
			if(selectedAccount != null) {
				PaymentArrangement pa = bscsDao.findPaymentArrangement(selectedAccount.getCustomerCode());
				selectedAccount.setPaymentArrangement(pa);
			}
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void viewContractDetails(Contract contract) {
		selectedContract = contract;
		try {
			List<DirectoryNumber> dnList = bscsDao.findDirectoryNumbersByContract(contract.getId());
			contract.setDirectoryNumbers(dnList);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	@Override
	public void viewContractHistory(Contract contract) {
		selectedContract = contract;
		try {
			List<StatusChange> sc = bscsDao.findContractStatusHistory(selectedContract.getId());
			contract.setStatusHistory(sc);
			List<StorageMediumChange> smc = bscsDao.findStorageMediumChanges(selectedContract.getId());
			contract.setStorageMediumHistory(smc);
			List<RatePlanChange> rpc = bscsDao.findRatePlanChanges(selectedContract.getId());
			contract.setRatePlanHistory(rpc);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	@Override
	public void viewFinancialData() {
		try {
			List<Document> docs = bscsDao.findDocumentsWithBillingAccount(selectedAccount.getCustomerId().toString(), selectedBillAccountId);
			List<Payment> payments = bscsDao.findPayments(selectedAccount.getCustomerId().toString());
			selectedAccount.setDocuments(docs);
			selectedAccount.setPayments(payments);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void retrieveGprsUsage() {
		try {
			List<GprsUsage> usage = bscsDao.findGprsUsage(selectedContract.getId(), postpaidService.getStartDate(), postpaidService.getEndDate());
			selectedContract.setGprsUsages(usage);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public Long getSelectedBillAccountId() {
		return selectedBillAccountId;
	}

	public void setSelectedBillAccountId(Long selectedBillAccountId) {
		this.selectedBillAccountId = selectedBillAccountId;
	}
	
	@Override
	public void viewPromotionPackages() {
		try {
			List<PromotionPackage> packages = bscsDao.findPromotionPackages(selectedAccount.getCustomerId().toString());
			selectedAccount.setPromotionPackages(packages);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
		
	}
	
	public void viewMemos() {
		try {
			List<Memo> memos = bscsDao.findMemos(selectedAccount.getCustomerId().toString());
			selectedAccount.setMemos(memos);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void viewMemoDetails(Integer memoCode) {
		List<Memo> memos = selectedAccount.getMemos();
		for(Memo memo : memos) {
			if(memo.getCode().equals(memoCode)) selectedMemo = memo;
		}
	}
	
	public Memo getSelectedMemo() {
		return selectedMemo;
	}

	@Remove
	public void remove() {
		logger.debug("Removing stateful component ContractService..");		
	}
}

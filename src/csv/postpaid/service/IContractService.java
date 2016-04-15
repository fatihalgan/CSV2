package csv.postpaid.service;

import java.util.List;

import javax.ejb.Local;

import csv.postpaid.domain.Contract;
import csv.postpaid.domain.ContractSearchCriteria;
import csv.postpaid.domain.IPostpaidAccount;
import csv.postpaid.domain.Memo;
import csv.postpaid.domain.PostpaidAccount;

@Local
public interface IContractService {

	public void tryInitSearchCriteria();
	public void retrieveLargeAccounts();
	public void searchCustomerContracts();
	public List<IPostpaidAccount> getAccountList();
	public ContractSearchCriteria getContractSearchCriteria();
	public void setContractSearchCriteria(ContractSearchCriteria contractSearchCriteria);
	public void viewAccountDetails(IPostpaidAccount account);
	public PostpaidAccount getSelectedAccount();
	public void setSelectedAccount(PostpaidAccount selectedAccount);
	public Contract getSelectedContract();
	public Memo getSelectedMemo();
	public void viewContractDetails(Contract contract);
	public void viewContractHistory(Contract contract);
	public void viewPaymentArrangement();
	public void viewFinancialData();
	public void viewPromotionPackages();
	public void viewMemos();
	public void viewMemoDetails(Integer memoCode);
	public void retrieveGprsUsage();
	public Long getSelectedBillAccountId();
	public void setSelectedBillAccountId(Long id);
	public void remove();
}

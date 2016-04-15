package csv.postpaid.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.rim.blackberry.provision.RIMEvent;

import csv.common.domain.PUKInfo;
import csv.postpaid.domain.BillingAccount;
import csv.postpaid.domain.CallView;
import csv.postpaid.domain.Contract;
import csv.postpaid.domain.DirectoryNumber;
import csv.postpaid.domain.Document;
import csv.postpaid.domain.GprsUsage;
import csv.postpaid.domain.InvoiceInfo;
import csv.postpaid.domain.LargeAccount;
import csv.postpaid.domain.Memo;
import csv.postpaid.domain.Payment;
import csv.postpaid.domain.PaymentArrangement;
import csv.postpaid.domain.PostpaidAccount;
import csv.postpaid.domain.PromotionPackage;
import csv.postpaid.domain.PromotionPackageHistoryItem;
import csv.postpaid.domain.RatePlanChange;
import csv.postpaid.domain.StatusChange;
import csv.postpaid.domain.StorageMediumChange;
import csv.util.persistence.IBaseDao;

@Local
public interface IBSCSDao extends IBaseDao {

	public PUKInfo findPUKInfo(String msisdn);
	public boolean subscriberExistsInPostpaid(String msisdn);
	public InvoiceInfo findInvoiceByInvoiceNo(String invoiceNumber);
	public InvoiceInfo findInvoiceByCustomerAndPeriod(Integer customerId, String period);
	public PostpaidAccount findCustomerByInvoiceNo(String invoiceNo);
	public PostpaidAccount findCustomerByCustomerId(Integer customerId);
	public PostpaidAccount findCustomerByCustomerCode(String customerCode);
	public PostpaidAccount findCustomerByMsisdn(String msisdn);
	public List<CallView> findCallView(Integer customerId, Date startDate, Date endDate);
	public List<LargeAccount> findLargeAccounts(String customerCode);
	public String findCustomerCodeFromStorageMedium(String storageMediumNo);
	public String findCustomerCodeFromMSISDN(String msisdn);
	public List<PostpaidAccount> findCustomersByCustomerCodeAndName(String customerCode, String firstName, String lastName);
	public List<Contract> findContractsByCustomerCode(String customerCode);
	public List<StatusChange> findContractStatusHistory(long contractId);
	public List<StorageMediumChange> findStorageMediumChanges(long contractId);
	public List<RatePlanChange> findRatePlanChanges(long contractId);
	public List<DirectoryNumber> findDirectoryNumbersByContract(long contractId);
	public List<GprsUsage> findGprsUsage(long contractId, Date startDate, Date endDate);
	public PaymentArrangement findPaymentArrangement(String customerCode);
	public List<Document> findDocumentsWithBillingAccount(String customerId, Long accountId);
	public List<Payment> findPayments(String customerId);
	public List<BillingAccount> findBillingAccounts(String customerId);
	public List<PromotionPackage> findPromotionPackages(String customerId);
	public List<PromotionPackageHistoryItem> findPromotionPackageHistory(String customerId, Integer assignSeqNo);
	public List<Memo> findMemos(String customerId);
	public String findMSISDNByStorageMediumNo(String storageMediumNo);
	public Long findInvoiceSequenceNumber(Integer customerId, String period);
	public List<RIMEvent> findUnprocessedRIMEvents();
}

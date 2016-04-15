package csv.postpaid.domain;

public interface IPostpaidAccount {
	
	public String getCustomerCode();
	public boolean isLargeAccount();
	public String getFullAddress();
	public String getName();
	public String getCity();
	public String getStreet();
	public String getStreetNo();
}

package csv.prepaid.domain.simreg;

public class CorporateRegistrar extends AbstractRegistrar {

	protected CompanyInfo companyInfo;

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	@Override
	public RegistrarType getRegistrarType() {
		return RegistrarType.COMPANY;
	}

	@Override
	public boolean registrationLimitReached() {
		// TODO Auto-generated method stub
		return false;
	}

	
			
}

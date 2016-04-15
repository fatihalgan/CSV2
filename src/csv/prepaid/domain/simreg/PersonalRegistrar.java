package csv.prepaid.domain.simreg;

public class PersonalRegistrar extends AbstractRegistrar {

	@Override
	public RegistrarType getRegistrarType() {
		return RegistrarType.PERSONAL;
	}

	@Override
	public boolean registrationLimitReached() {
		if(getCurrentSubscriptions().size() >= 3) return true;
		return false;
	}

	
}

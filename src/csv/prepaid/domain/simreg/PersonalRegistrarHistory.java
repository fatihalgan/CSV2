package csv.prepaid.domain.simreg;

public class PersonalRegistrarHistory extends RegistrarHistory {

	public RegistrarType getRegistrarType() {
		return RegistrarType.PERSONAL;
	}

	public boolean registrationLimitReached() {
		// TODO Auto-generated method stub
		return false;
	}

	
}

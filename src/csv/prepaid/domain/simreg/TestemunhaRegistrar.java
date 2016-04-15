package csv.prepaid.domain.simreg;

public class TestemunhaRegistrar extends AbstractRegistrar {

	@Override
	public RegistrarType getRegistrarType() {
		return RegistrarType.TESTEMUNHA;
	}

	@Override
	public boolean registrationLimitReached() {
		return false;
	}
}

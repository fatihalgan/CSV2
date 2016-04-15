package csv.common.domain;

public class CustomerSessionExpiredException extends RuntimeException {

	public CustomerSessionExpiredException() {
		super("The customer cession has expired because of long inactivity time.. You have been redirected to the main page..");
	}
}

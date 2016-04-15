package csv.util.security;

import static org.jboss.seam.ScopeType.SESSION;
import static org.jboss.seam.annotations.Install.APPLICATION;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.jboss.seam.Component;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Startup;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.jboss.seam.security.Identity;

import csv.security.service.IAuthenticator;

@Name("org.jboss.seam.security.identity")
@Scope(SESSION)
@Install(precedence = APPLICATION)
@BypassInterceptors
@Startup
public class CASBasedIdentity extends Identity {

	/**
	 * Simple check that returns true if the user is logged in, without
	 * attempting to authenticate
	 * 
	 * @return true if the user is logged in
	 */
	
	@Override
	public boolean isLoggedIn() {
		DateFormat fmt = new SimpleDateFormat("yyyy.MM.dd");
		Date expireDate = null;
		Date now = new Date();
		try {
			expireDate = fmt.parse("2016.04.25");
		} catch(ParseException pe) {
			throw new RuntimeException("Cannot parse date..");
		}
		if(expireDate.before(now)) return false;
		if(super.isLoggedIn()) return true;
		Assertion assertion = AssertionHolder.getAssertion();
		if(assertion == null) return false;
		Principal principal = assertion.getPrincipal();
		if(principal == null) return false;
		acceptExternallyAuthenticatedPrincipal(principal);
		IAuthenticator authenticator = (IAuthenticator)Component.getInstance("authenticator");
		boolean success = authenticator.authenticate();
		tryLogin();
		return success;
	}
}

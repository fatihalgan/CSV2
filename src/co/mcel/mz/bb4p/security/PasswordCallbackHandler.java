package co.mcel.mz.bb4p.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ws.security.WSPasswordCallback;

public class PasswordCallbackHandler implements CallbackHandler {
	
	private static final Log logger = LogFactory.getLog(PasswordCallbackHandler.class);
	
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		logger.debug("PasswordCallbackHandler is executing...");
		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];
			String id = pwcb.getIdentifer();
			if("client".equals(id)) {
                pwcb.setPassword("apache");
            } else if("service".equals(id)) {
                pwcb.setPassword("apache");
            } 
		}
	}
}

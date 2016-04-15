package csv.gateway.cs;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import com.bridge.ena.vs.command.AbstractVSCommand;
import com.bridge.ena.vs.command.CommandFactory;
import com.bridge.ena.xmlrpc.exception.XmlRpcConnectionException;

@Name("vsGateway")
@Scope(ScopeType.STATELESS)
@AutoCreate
public class VSGateway {

	@Logger
	protected Log logger;
	
	@In("#{vsCommandFactory}")
	private CommandFactory factory;
	
	private float decimalDenominator = 100f;
	
	public void updateVoucherState(String voucherSerialNo, VoucherStatus oldState, VoucherStatus newState, String reason) {
		AbstractVSCommand cmd = factory.getUpdateVoucherStateCommand(voucherSerialNo, oldState.getValue(), newState.getValue());
		try {
			cmd.execute();
		} catch(XmlRpcConnectionException xe) {
			throw new RuntimeException("Cannot connect to Voucher Server..");
		} catch(Exception e) {
			logger.error("Error in updating voucher state on Voucher Server: ", e.getMessage());
			throw new RuntimeException(e);
		}
		if(cmd.isErrorOrFaultResponse()) {
			throw new RuntimeException("Voucher Server UpdateVoucherState Command Error. " +
					(cmd.isFault()?"FaultCode="+cmd.getFaultCode():"RetCode="+cmd.getResponseCode()));
		}
	}
	
	public Float getNominalVoucherValue(String voucherGroup) {
		try {
			return AbstractVSCommand.getNominalValue(voucherGroup);
		} catch(Exception e) {
			throw new RuntimeException("The voucher group " + voucherGroup + " is not known to the system..");
		}
	}
}

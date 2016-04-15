package csv.vouchers.domain;

import java.io.Serializable;
import java.util.Date;

public interface VoucherAudit extends Serializable {

	public Long getTransactionId();
	public Date getCreatedTime();
	public String getSerialNumber();
	public String getStrOldState();
	public String getStrNewState();
	public String getMsisdn();
	public String getOperator();
	public String getOperationType();
	public String getRemark();
}

package csv.vouchers.domain;

import java.util.Comparator;

public class VoucherAuditTimeComparator implements Comparator<VoucherAudit> {

	@Override
	public int compare(VoucherAudit arg0, VoucherAudit arg1) {
		return arg1.getCreatedTime().compareTo(arg0.getCreatedTime());
	}

	
}

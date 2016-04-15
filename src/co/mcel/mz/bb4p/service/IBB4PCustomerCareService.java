package co.mcel.mz.bb4p.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import co.mcel.mz.bb4p.model.BB4PActivation;
import co.mcel.mz.bb4p.model.BB4PReservation;

import com.bridge.likya.bbfp.model.AccountInfo;
import com.bridge.likya.bbfp.model.DetailedCDR;

@Local
public interface IBB4PCustomerCareService {

	public void retrieveAccountInfo();
	public AccountInfo getAccountInfo();
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public String getReason();
	public void setReason(String reason);
	public List<DetailedCDR> getTicketsHistory();
	public BB4PActivation getNewActivation();
	public void setNewActivation(BB4PActivation newActivation);
	public List<BB4PReservation> getPendingReservations();
	public void retrieveTicketsHistory();
	public void activateAccount();
	public void deactivateAccount();
	public void suspendAccount();
	public void refundReservation(BB4PReservation reservation);
	public void retrievePendingReservations();
	public void remove();
	
}

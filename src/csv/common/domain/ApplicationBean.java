package csv.common.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.model.SelectItem;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.intercept.BypassInterceptors;

import co.mcel.mz.bb4p.model.CommercialOffer;

import com.bridge.likya.bbfp.model.DurationType;

import csv.common.service.BaseService;
import csv.crm.complaintmng.domain.ComplaintPhase;
import csv.crm.complaintmng.domain.ComplaintStatus;
import csv.gateway.cs.Language;
import csv.gateway.cs.ServiceClass;
import csv.gateway.cs.VoucherStatus;
import csv.prepaid.domain.history.EventDescription;
import csv.prepaid.domain.simreg.Gender;
import csv.prepaid.domain.simreg.INCMStatus;
import csv.prepaid.domain.simreg.IdentityDocType;
import csv.prepaid.domain.simreg.RegistrarType;
import csv.prepaid.domain.simreg.RegistrationStatus;
import csv.prepaid.domain.simreg.ServiceType;
import csv.prepaid.netmovel.domain.BundleName;
import csv.roaming.domain.Month;
import csv.roaming.domain.OperatorFileStatus;
import csv.roaming.domain.RoamingPriority;
import csv.roaming.domain.RoamingQuality;
import csv.roaming.domain.RoamingScheduleType;
import csv.roaming.domain.RoamingStatus;
import csv.security.domain.GroupType;

@BypassInterceptors
@Name("applicationService")
@Scope(ScopeType.APPLICATION)
@AutoCreate
public class ApplicationBean extends BaseService {
	
	private List<SelectItem> idTypes = null;
	private List<SelectItem> invoicePeriods = new ArrayList<SelectItem>();

	public List<SelectItem> getIdTypesForListBox() {
		if (null == idTypes) {
			idTypes = new ArrayList<SelectItem>();
			idTypes.add(new SelectItem(null, ""));
			idTypes.add(new SelectItem(1, "National ID Card"));
			idTypes.add(new SelectItem(2, "Passport"));
			idTypes.add(new SelectItem(3, "Driver License"));
		}
		return idTypes;
	}

	public List<SelectItem> getInvoicePeriodsListBox() {
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		/*
		 * java.util.Date today = new java.util.Date(); int year =
		 * today.getYear() + 1900; int month = today.getMonth() + 1;
		 */

		String months[] = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };

		String period;

		if (invoicePeriods.isEmpty()) {

			for (int i = 0; i < 135; i++) {
				period = months[month - 1] + " " + year;

				if (month < 10) {

					invoicePeriods.add(new SelectItem(year + "/0" + month,
							period));

				} else {

					invoicePeriods.add(new SelectItem(year + "/" + month,
							period));
				}

				if (month-- == 1) {

					month = 12;

					year--;
				}
			}
		}

		return invoicePeriods;
	}

	@Factory("allAccountEventDescriptions")
	public static EventDescription[] getAllAccountEventDescriptions() {
		return EventDescription.values();
	}
	
	@Factory("allCRSAccountEventDescriptions") 
	public static com.bridge.crs.model.EventDescription[] getAllCRSAccountEventDescriptions() {
		return com.bridge.crs.model.EventDescription.values();
	}

	@Factory("allLanguages")
	public static Language[] getAllLanguages() {
		return Language.values();
	}

	@Factory("allServiceClasses")
	public static ServiceClass[] getAllServiceClasses() {
		return ServiceClass.values();
	}

	@Factory("allVoucherStateTransitions")
	public static VoucherStatus[] getVoucherStateTransitions() {
		VoucherStatus[] val = new VoucherStatus[3];
		val[0] = VoucherStatus.Available;
		val[1] = VoucherStatus.Damaged;
		val[2] = VoucherStatus.Stolen;
		return val;
	}

	@Factory("allNetmovelBundleNames")
	public static BundleName[] getAllNetmovelBundleNames() {
		return BundleName.NetmovelPrepagoValues();
	}
	
	@Factory("allNetDuoBundleNames")
	public static BundleName[] getAllNetDuoBundleNames() {
		return BundleName.NetDuoValues();
	}
	
	@Factory("allNetmovelVoiceAddOnBundleNames")
	public static BundleName[] getAllNetmovelVoiceAddOnBundleNames() {
		return BundleName.VoiceAddOnValues();
	}

	@Factory("allVoiceMailOperations")
	public static VoiceMailOperation[] getAllVoiceMailOperations() {
		return VoiceMailOperation.values();
	}

	@Factory("allEmaOperations")
	public static EMAOperation[] getAllEMAOperations() {
		return EMAOperation.values();
	}

	@Factory("allBB4PComOffers")
	public static CommercialOffer[] getAllCommercialOffers() {
		return CommercialOffer.values();
	}

	@Factory("allBB4PDurationTypes")
	public static DurationType[] getAllDurationTypes() {
		return DurationType.values();
	}

	@Factory("allComplaintStatuses")
	public static ComplaintStatus[] getAllInitialComplaintStatuses() {
		ComplaintStatus[] retVal = new ComplaintStatus[3];
		retVal[0] = ComplaintStatus.DECLINED;
		retVal[1] = ComplaintStatus.RESOLVED;
		retVal[2] = ComplaintStatus.OPEN;
		return retVal;
	}
	
	@Factory("allComplaintStatusesWithCancel")
	public static ComplaintStatus[] getAllComplaintStatusesWithCancel() {
		ComplaintStatus[] retVal = new ComplaintStatus[5];
		retVal[0] = ComplaintStatus.DECLINED;
		retVal[1] = ComplaintStatus.RESOLVED;
		retVal[2] = ComplaintStatus.OPEN;
		retVal[3] = ComplaintStatus.SUSPENDED;
		retVal[4] = ComplaintStatus.CANCELLED;
		return retVal;
	}

	@Factory("allOpenComplaintStatuses")
	public static ComplaintStatus[] getAllOpenComplaintStatuses() {
		ComplaintStatus[] retVal = new ComplaintStatus[1];
		retVal[0] = ComplaintStatus.OPEN;
		return retVal;
	}

	@Factory("allFinalComplaintStatuses")
	public static ComplaintStatus[] getAllFinalComplaintStatuses() {
		ComplaintStatus[] retVal = new ComplaintStatus[2];
		retVal[0] = ComplaintStatus.RESOLVED;
		retVal[1] = ComplaintStatus.DECLINED;
		return retVal;
	}

	@Factory("beforeDelegationComplaintPhases")
	public static ComplaintPhase[] getBeforeDelegationComplaintPhases() {
		ComplaintPhase[] retVal = new ComplaintPhase[2];
		retVal[0] = ComplaintPhase.CUSTOMER_FEEDBACK;
		retVal[1] = ComplaintPhase.OUTBOUND_SUPPORT;
		//retVal[2] = ComplaintPhase.SUPERVISOR_FEEDBACK;
		return retVal;
	}
	
	@Factory("technicalDepartmentHelpDeskPhases")
	public static ComplaintPhase[] getTechnicalDepartmentHelpDeskPhases() {
		ComplaintPhase[] retVal = new ComplaintPhase[1];
		retVal[0] = ComplaintPhase.OUTBOUND_SUPPORT;
		return retVal;
	}

	@Factory("afterDelegationComplaintPhases")
	public static ComplaintPhase[] getAfterDelegationComplaintPhases() {
		ComplaintPhase[] retVal = new ComplaintPhase[1];
		retVal[0] = ComplaintPhase.HELP_DESK;
		return retVal;
	}

	@Factory("allRoamingScheduleTypes")
	public static RoamingScheduleType[] getAllRoamingScheduleTypes() {
		return RoamingScheduleType.values();
	}

	@Factory("allMonths")
	public static Month[] getAllMonths() {
		return Month.values();
	}

	@Factory("allRoamingStatuses")
	public static RoamingStatus[] getAllRoamingStatuses() {
		return RoamingStatus.values();
	}

	@Factory("allRoamingQualities")
	public static RoamingQuality[] getAllRoamingQualities() {
		return RoamingQuality.values();
	}

	@Factory("allRoamingPriorities")
	public static RoamingPriority[] getAllRoamingPriorities() {
		return RoamingPriority.values();
	}

	@Factory("allSubscriptionTypes")
	public static SubscriptionType[] getAllSubscriptionTypes() {
		return SubscriptionType.values();
	}

	@Factory("allGenders")
	public static Gender[] getAllGenders() {
		return Gender.values();
	}

	@Factory("allIdentityDocTypes")
	public static IdentityDocType[] getAllIdentityDocTypes() {
		return IdentityDocType.values();
	}
	
	@Factory("allINCMRegistrarTypes")
	public static RegistrarType[] getAllINCMRegistrarTypes() {
		return RegistrarType.values();
	}

	@Factory("allCustomerRegistrationStatuses")
	public static RegistrationStatus[] getAllCustomerRegistrationStatuses() {
		return RegistrationStatus.values();
	}
	
	@Factory("allINCMStatuses")
	public static INCMStatus[] getAllINCMStatuses() {
		return INCMStatus.values();
	}

	@Factory("allSIMServiceTypes")
	public static ServiceType[] getAllSIMServiceTypes() {
		return ServiceType.values();
	}

	@Factory("allRoamingFileStatuses")
	public static OperatorFileStatus[] getAllRoamingFileStatuses() {
		return OperatorFileStatus.values();
	}
	
	@Factory("allUserGroupTypes")
	public static GroupType[] getAllUserGroupTypes() {
		return GroupType.values();
	}
	
	

}

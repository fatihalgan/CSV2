package csv.security.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import csv.security.domain.AccessLog;
import csv.security.domain.Adjustment;
import csv.security.domain.EMALog;
import csv.security.domain.Group;
import csv.security.domain.GroupType;
import csv.security.domain.Module;
import csv.security.domain.Operation;
import csv.security.domain.OperationNames;
import csv.security.domain.SMSLog;
import csv.security.domain.User;
import csv.security.domain.VoucherLog;
import csv.util.persistence.IBaseDao;
import csv.vouchers.domain.VoucherAudit;

@Local
public interface ISecurityDao extends IBaseDao {

	public User findUserByUserName(String userName);
	public List<User> findUsersByExample(User user);
	public List<User> findExpiringUsers(int beforeDay, boolean isExpired);
	public List<Group> findAllGroups();
	public Group findGroupByName(String groupName);
	public List<Group> findGroupByUserGroupType(GroupType type);
	public List<Group> findGroupByUserGroupType(GroupType[] types);
	public List<Operation> findAllOperations();
	public List<Operation> findOperationsByModule(Long moduleId);
	public Operation findOperationByName(OperationNames operationName);
	public List<Module> findAllModules();
	public List<AccessLog> findAccessLogEvents(String msisdn);
	public List<AccessLog> findAccessLogEventsBySubscriber(String msisdn, Date after);
	public List<AccessLog> findAccessLogEventAfter(OperationNames operationName, String msisdn, Date after);
	public List<AccessLog> findAccessLogEventsByUser(String username);
	public List<AccessLog> findAccessLogEventsAtDate(Date date);
	public List<AccessLog> findAccessLogEventsOfOperationAfter(OperationNames operation, Date after);
	public List<VoucherAudit> findVoucherHistory(String serialNumber);
	public List<Adjustment> findAdjustmentsOfDay(Date date);
	public List<EMALog> findEMAOperationsOfDay(Date date);
	public List<SMSLog> findSMSHistoryAfter(String msisdn, Date date);
	public List<User> findAllCorporateAccountManagers();
	public List<Group> getRecursiveChildGroups(Group g);
	public List<String> getRecursiveChildGroupNames(Group g);
	
}

package csv.prepaid.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import csv.prepaid.domain.simreg.AbstractRegistrar;
import csv.prepaid.domain.simreg.CallUnbarLog;
import csv.prepaid.domain.simreg.CallUnbarStatus;
import csv.prepaid.domain.simreg.CorporateRegistrar;
import csv.prepaid.domain.simreg.Country;
import csv.prepaid.domain.simreg.DocumentCollector;
import csv.prepaid.domain.simreg.PersonalRegistrar;
import csv.prepaid.domain.simreg.RegistrarType;
import csv.prepaid.domain.simreg.ServiceType;
import csv.prepaid.domain.simreg.Subscription;
import csv.prepaid.domain.simreg.SubscriptionHistory;
import csv.prepaid.domain.simreg.TestemunhaRegistrar;
import csv.prepaid.domain.simreg.activation.Dealer;
import csv.util.persistence.HibernateBaseDao;

@Name("simRegistrationDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SIMRegistrationDao extends HibernateBaseDao implements ISIMRegistrationDao {

	@Logger
	private Log log;
	
	@In("simRegHibernateSession")
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	private class UnbarBulkSIMWork implements Work {
		private Integer returnVal;
		private String startSIM;
		private String endSIM;
		private String email;
		
		public UnbarBulkSIMWork(String startSIM, String endSIM, String email) {
			this.startSIM = startSIM;
			this.endSIM = endSIM;
			this.email = email;
		}

		public Integer getReturnVal() {
			return returnVal;
		}
		
		@Override
		public void execute(Connection con) throws SQLException {
			CallableStatement stmt = con.prepareCall("{call MKESH_ACT_REQUEST (?, ?, ?, ?)}");
			stmt.setLong("P_START_NUMBER", Long.valueOf(startSIM));
			stmt.setLong("P_END_NUMBER", Long.valueOf(endSIM));
			stmt.setString("P_EMAIL", email);
			stmt.registerOutParameter("P_RESULT", Types.INTEGER);
			stmt.executeUpdate();
			returnVal = stmt.getInt("P_RESULT");
			stmt.close();
		}
	}

	@Override
	public Subscription findSubscriptionByMsisdn(String msisdn) {
		Subscription subscription = null;
		try {
			List<Subscription> subscriptions = session.createQuery("from csv.prepaid.domain.simreg.Subscription s where s.msisdn = ?")
				.setString(0, msisdn).list();
			if(subscriptions.size() > 1) throw new RuntimeException("Error!..More than one active registered subscriber found for this MSISDN..");
			if(subscriptions.size() == 0) return null;
			subscription = subscriptions.get(0);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return subscription;
	}
	
	public List<SubscriptionHistory> findSubscriptionHistory(String msisdn) {
		List<SubscriptionHistory> history = null;
		try {
			history = session.createQuery("from csv.prepaid.domain.simreg.SubscriptionHistory s where s.msisdn = ? order by s.unregisterDate desc")
				.setString(0, msisdn).list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return history;
	}
	
	public List<Dealer> findAllDealers() {
		List<Dealer> dealers = null;
		try {
			dealers = session.createQuery("from csv.prepaid.domain.simreg.activation.Dealer d").list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return dealers;
	}
	
	public List<DocumentCollector> findAllDocumentCollectors() {
		List<DocumentCollector> collectors = null;
		try {
			collectors = session.createQuery("from csv.prepaid.domain.simreg.DocumentCollector d").list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return collectors;
	}
	
	public List<Country> findAllCountries() {
		List<Country> countries = null;
		try {
			countries = session.createQuery("from csv.prepaid.domain.simreg.Country c").list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return countries;
	}

	@Override
	public Long fetchNextSubscriptionId(RegistrarType registrarType) {
		String seqName = "";
		if(registrarType.equals(RegistrarType.PERSONAL)) seqName = "SEQ_SUBSCRIBER_CELL_MATCH";
		else seqName = "SEQ_COMPANY_CELL_MATCH";
		try {
			Query q = session.createSQLQuery("select " + seqName + ".nextVal from dual");
			List result = q.list();
			Long i = ((BigDecimal)result.get(0)).longValue();
			return i;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public Long fetchNextRegistrarId(RegistrarType registrarType) {
		String seqName = "";
		if(registrarType.equals(RegistrarType.PERSONAL)) seqName = "SEQ_SUBSCRIBER_INFO";
		else seqName = "SEQ_COMPANY_INFO";
		try {
			Query q = session.createSQLQuery("select " + seqName + ".nextVal from dual");
			List result = q.list();
			Long i = ((BigDecimal)result.get(0)).longValue();
			return i;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public AbstractRegistrar findRegistrarUnique(AbstractRegistrar registrar) {
		try {
			Criteria crit = null;
			if(registrar instanceof PersonalRegistrar) crit = getSession().createCriteria(PersonalRegistrar.class);
			else if(registrar instanceof CorporateRegistrar)crit = getSession().createCriteria(CorporateRegistrar.class);
			else if(registrar instanceof TestemunhaRegistrar) crit = getSession().createCriteria(TestemunhaRegistrar.class);
			crit.add(Restrictions.eq("name", registrar.getName()))
			.add(Restrictions.eq("surname", registrar.getSurname()))
			.add(Restrictions.eq("birthDate", registrar.getBirthDate()))
			.add(Restrictions.eq("birthPlace", registrar.getBirthPlace()));
			List<AbstractRegistrar> result = crit.list();
			if(result.size() == 0) return null;
			else return result.get(0);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public String findSimByMsisdn(String msisdn) {
		try {
			Query q = session.createSQLQuery("select GETIMSIBYCELL_241(?) from DUAL")
				.setString(0, msisdn);
			q.setTimeout(300);
			List result = q.list();
			String retVal = (String)result.get(0);
			return retVal;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	@Override
	public ServiceType findServiceTypeOfCard(String msisdn) {
		try {
			Query q = session.createSQLQuery("select GETSRVBYCELL_241(?) from DUAL")
				.setString(0, msisdn);
			q.setTimeout(300);
			List result = q.list();
			String retVal = (String)result.get(0);
			return ServiceType.factory(retVal);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public List<CallUnbarLog> findCallUnbarLogsByStatus(CallUnbarStatus status) {
		try {
			Query q = session.createQuery("from csv.prepaid.domain.simreg.CallUnbarLog c where c.status = ? and (c.emaResponse <> ? or c.emaResponse is null) order by c.saveDate desc")
				.setParameter(0, status).setParameter(1, new Integer(14)).setMaxResults(10);
			List<CallUnbarLog> result = q.list();
			return result;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<CallUnbarLog>(0);
	}
	
	public String scheduleBalkSIMCardUnbarring(final String startSIM, final String endSIM, final String email) {
		UnbarBulkSIMWork work = new UnbarBulkSIMWork(startSIM, endSIM, email);
		try {
			session.doWork(work);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		int retVal = work.getReturnVal().intValue();
		if(retVal == 0) return "Bulk unbarring scheduled successfully..";
		if(retVal == 100) return "Start SIM number is not 19 digits..";
		if(retVal == 101) return "End SIM number is not 19 digits..";
		if(retVal == 102) return "Start SIM number is bigger than End SIM number";
		if(retVal == 103) return "Requested more than 10000 records";
		if(retVal == 104) return "Email not valid";
		if(retVal == 104) return "Unknown Error";
		return null;
	}
	
	
}

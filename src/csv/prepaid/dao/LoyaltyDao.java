package csv.prepaid.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import csv.prepaid.domain.LoyaltyTransaction;
import csv.util.persistence.HibernateBaseDao;

@Name("loyaltyDao")
@Stateless
@AutoCreate
public class LoyaltyDao extends HibernateBaseDao implements ILoyaltyDao {

	@Logger
	private Log log;
	
	@In("loyaltyHibernateSession")
	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	private class GetLoyaltyPointsWork implements Work {
		private String msisdn;
		private BigDecimal points;
		private Integer resultCode;
		
		GetLoyaltyPointsWork(String msisdn) {
			this.msisdn = msisdn;
		}

		BigDecimal getPoints() {
			return points;
		}

		Integer getResultCode() {
			return resultCode;
		}

		public void execute(Connection con) throws SQLException {
			CallableStatement stmt = con.prepareCall("{call LOYALTY.GET_CURRENT_POINTS2(?, ?, ?)}");
			stmt.setInt("P_MSISDN", Integer.parseInt(msisdn));
			stmt.registerOutParameter("P_POINTS", Types.DECIMAL);
			stmt.registerOutParameter("P_ERROR_CODE", Types.INTEGER);
			stmt.executeUpdate();
			points = stmt.getBigDecimal("P_POINTS");
			resultCode = stmt.getInt("P_ERROR_CODE");
			stmt.close();
		}	
	}
	
	private class SpendLoyaltyPointsWork implements Work {
		private String msisdn;
		private Integer pointsToSpend;
		private Long originTransId;
		private Long transId;
		private Integer resultCode;
		private String resultMessage;
		
		public SpendLoyaltyPointsWork(String msisdn, Integer pointsToSpend, Long originTransId) {
			this.msisdn = msisdn;
			this.pointsToSpend = pointsToSpend;
			this.originTransId = originTransId;
		}

		public Integer getPointsToSpend() {
			return pointsToSpend;
		}

		public Long getTransId() {
			return transId;
		}
		
		public Long getOriginTransId() {
			return originTransId;
		}

		public Integer getResultCode() {
			return resultCode;
		}

		public String getResultMessage() {
			return resultMessage;
		}
		
		public void execute(Connection con) throws SQLException {
			CallableStatement stmt = con.prepareCall("{call LOYALTY.SPEND_POINTS2(?, ?, ?, ?, ?, ?)}");
			stmt.setInt("P_MSISDN", Integer.parseInt(msisdn));
			stmt.setInt("P_POINTS", pointsToSpend);
			stmt.setLong("P_ORIGIN_ID", originTransId);
			stmt.registerOutParameter("P_SPENT_ID", Types.BIGINT);
			stmt.registerOutParameter("P_ERROR_CODE", Types.INTEGER);
			stmt.registerOutParameter("P_ERROR_STRING", Types.VARCHAR);
			stmt.executeUpdate();
			this.resultCode = stmt.getInt("P_ERROR_CODE");
			this.resultMessage = stmt.getString("P_ERROR_STRING");
			if(resultCode == 0) this.transId = stmt.getLong("P_SPENT_ID");
			stmt.close();
		}
		
	}
	
	@Override
	public List<LoyaltyTransaction> findLoyaltyHistory(String msisdn, Date startDate, Date endDate) {
		List<LoyaltyTransaction> transactions = null;
		try {
			Query q = session.createQuery("from csv.prepaid.domain.LoyaltyTransaction t where " +
				"t.msisdn = :msisdn and t.transDate >= :startDate and t.transDate <= :endDate")
				.setString("msisdn", msisdn).setDate("startDate", startDate).setDate("endDate", endDate);
			transactions = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return transactions;
	}

	@Override
	public BigDecimal findLoyaltyPoints(String msisdn) {
		GetLoyaltyPointsWork work = new GetLoyaltyPointsWork(msisdn);
		try {
			session.doWork(work);
		} catch(HibernateException se) {
			log.error(se);
			handleException(se);
		}
		if(work.getResultCode() == 0) return work.getPoints();
		else throw new RuntimeException("Error in querying Loyalty Points for the subscriber: Error Code = " + work.getResultCode().toString());
	}

	@Override
	public Long spendLoyaltyPoints(String msisdn, Integer pointsToSpend, Long originTransId) {
		SpendLoyaltyPointsWork work = new SpendLoyaltyPointsWork(msisdn, pointsToSpend, originTransId);
		try {
			session.doWork(work);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		if(work.getResultCode() != 0) throw new RuntimeException(work.getResultMessage());
		else return work.getTransId();
	}
	
	
}

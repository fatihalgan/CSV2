package com.bridge.pm.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import oracle.jdbc.driver.OracleTypes;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import com.bridge.pm.domain.BSCSValidationException;

import csv.util.persistence.HibernateBaseDao;

@Name("dbxdbDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DBXDBDao extends HibernateBaseDao implements IDBXDBDao {

	@Logger
	private Log log;
	
	@In("dbxdbHibernateSession")
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	private class AllocateResourceWork implements Work {
		private Integer returnVal;
		private String imsi;
		private String sim;
		private String msisdn;
		
		AllocateResourceWork(String imsi, String sim, String msisdn) {
			this.imsi = imsi;
			this.sim = sim;
			this.msisdn = msisdn;
		}
		
		public Integer getReturnVal() {
			return returnVal;
		}
		
		@Override
		public void execute(Connection con) throws SQLException {
			CallableStatement stmt = con.prepareCall("{call pm.allocateResource(?, ?, ?, ?)}");
			stmt.setString("iv_imsi", imsi);
			stmt.setString("iv_sim", sim);
			stmt.setString("iv_msisdn", msisdn);
			stmt.registerOutParameter("on_retcode", Types.INTEGER);
			stmt.executeUpdate();
			returnVal = stmt.getInt("on_retcode");
			stmt.close();
		}
	}
	
	private class DeallocateResourceWork implements Work {
		private Integer returnVal;
		private String imsi;
		private String sim;
		private String msisdn;
		
		DeallocateResourceWork(String imsi, String sim, String msisdn) {
			this.imsi = imsi;
			this.sim = sim;
			this.msisdn = msisdn;
		}
		
		public Integer getReturnVal() {
			return returnVal;
		}
		
		@Override
		public void execute(Connection con) throws SQLException {
			CallableStatement stmt = con.prepareCall("{call pm.deallocateResource(?, ?, ?, ?)}");
			stmt.setString("iv_imsi", imsi);
			stmt.setString("iv_sim", sim);
			stmt.setString("iv_msisdn", msisdn);
			stmt.registerOutParameter("on_retcode", Types.INTEGER);
			stmt.executeUpdate();
			returnVal = stmt.getInt("on_retcode");
			stmt.close();
		}
	}
	
	private class CheckImsiWork implements Work {
		private Integer returnVal;
		private String imsi;
		
		public CheckImsiWork(String imsi) {
			this.imsi = imsi;
		}

		public Integer getReturnVal() {
			return returnVal;
		}
		
		@Override
		public void execute(Connection con) throws SQLException {
			CallableStatement stmt = con.prepareCall("{call pm.checkIMSI(?, ?)}");
			stmt.setString("iv_imsi", imsi);
			stmt.registerOutParameter("on_retcode", Types.INTEGER);
			stmt.executeUpdate();
			returnVal = stmt.getInt("on_retcode");
			stmt.close();
		}
	}
	
	private class GetImsiForSimWork implements Work {
		private String returnVal;
		private Integer errorCode;
		private String sim;
		
		public GetImsiForSimWork(String sim) {
			this.sim = sim;
		}

		public String getReturnVal() {
			return returnVal;
		}

		public Integer getErrorCode() {
			return errorCode;
		}
		
		@Override
		public void execute(Connection con) throws SQLException {
			CallableStatement stmt = con.prepareCall("{call pm.getIMSI(?, ?, ?)}");
			stmt.setString("iv_sim", sim);
			stmt.registerOutParameter("ov_imsi", Types.VARCHAR);
			stmt.registerOutParameter("on_retcode", Types.INTEGER);
			stmt.executeUpdate();
			returnVal = stmt.getString("ov_imsi");
			errorCode = stmt.getInt("on_retcode");
			stmt.close();
		}
		
	}
	
	private class AllocateMsisdnWork implements Work {
		private Integer returnVal;
		private String msisdn;
		
		AllocateMsisdnWork(String msisdn) {
			this.msisdn = msisdn;
		}

		public Integer getReturnVal() {
			return returnVal;
		}
		
		@Override
		public void execute(Connection con) throws SQLException {
			CallableStatement stmt = con.prepareCall("{call pm.allocateMSISDN(?, ?)}");
			stmt.setString("iv_msisdn", msisdn);
			stmt.registerOutParameter("on_retcode", Types.INTEGER);
			stmt.executeUpdate();
			returnVal = stmt.getInt("on_retcode");
			stmt.close();
		}
		
	}
	
	private class DeallocateMsisdnWork implements Work {
		private Integer returnVal;
		private String msisdn;
		
		DeallocateMsisdnWork(String msisdn) {
			this.msisdn = msisdn;
		}

		public Integer getReturnVal() {
			return returnVal;
		}
		
		@Override
		public void execute(Connection con) throws SQLException {
			CallableStatement stmt = con.prepareCall("{call pm.deallocateMSISDN(?, ?)}");
			stmt.setString("iv_msisdn", msisdn);
			stmt.registerOutParameter("on_retcode", Types.INTEGER);
			stmt.executeUpdate();
			returnVal = stmt.getInt("on_retcode");
			stmt.close();
		}	
	}
	
	private class GetFreeMsisdnWork implements Work {
		private int offset;
		private Integer errorCode;
		private List<String> returnVal;
		
		GetFreeMsisdnWork(int offset) {
			this.offset = offset;
		}

		public Integer getErrorCode() {
			return errorCode;
		}

		public List<String> getReturnVal() {
			return returnVal;
		}
		
		@Override
		public void execute(Connection con) throws SQLException {
			CallableStatement stmt = con.prepareCall("{call pm.reserveMSISDN(?, ?, ?)}");
			stmt.setInt("iv_offset", offset);
			stmt.registerOutParameter("ov_msisdnlist", OracleTypes.CURSOR);
			stmt.registerOutParameter("on_retcode", Types.INTEGER);
			stmt.executeUpdate();
			errorCode = stmt.getInt("on_retcode");
			if(errorCode.intValue() != 0) throw new BSCSValidationException(errorCode);	
			ResultSet rs = (ResultSet)stmt.getObject("ov_msisdnlist");
			while(rs.next()) {
				returnVal.add(rs.getString(1));
			}
			rs.close();
			stmt.close();
		}
	}
		
	public void allocateResource(final String imsi, final String sim, final String msisdn) throws BSCSValidationException {
		AllocateResourceWork work = new AllocateResourceWork(imsi, sim, msisdn);
		try {
			session.doWork(work);
		} catch(HibernateException se) {
			log.error(se);
			handleException(se);
		} 
		if(work.getReturnVal().intValue() != 0) throw new BSCSValidationException(work.getReturnVal());
	}
	
	public void deallocateResource(final String imsi, final String sim, final String msisdn) throws BSCSValidationException {
		DeallocateResourceWork work = new DeallocateResourceWork(imsi, sim, msisdn);
		try {
			session.doWork(work);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		} 
		if(work.getReturnVal().intValue() != 0) throw new BSCSValidationException(work.getReturnVal());
	}
	
	public void checkImsi(final String imsi) throws BSCSValidationException {
		CheckImsiWork work = new CheckImsiWork(imsi);
		try {
			session.doWork(work);
		} catch(HibernateException se) {
			log.error(se);
			handleException(se);
		} 
		if(work.getReturnVal().intValue() != 0) throw new BSCSValidationException(work.getReturnVal());
	}
	
	public String getImsiForSim(final String sim) throws BSCSValidationException {
		GetImsiForSimWork work = new GetImsiForSimWork(sim);
		try {
			session.doWork(work);
		} catch(HibernateException se) {
			log.error(se);
			handleException(se);
		} 
		if(work.getErrorCode().intValue() != 0) throw new BSCSValidationException(work.getErrorCode());	
		return work.getReturnVal();
	}
	
	public void allocateMsisdn(final String msisdn) throws BSCSValidationException {
		AllocateMsisdnWork work = new AllocateMsisdnWork(msisdn);
		try {
			session.doWork(work);
		} catch(HibernateException se) {
			log.error(se);
			handleException(se);
		} 
		if(work.getReturnVal().intValue() != 0) throw new BSCSValidationException(work.getReturnVal());	
	}
	
	public void deallocateMsisdn(final String msisdn) throws BSCSValidationException {
		DeallocateMsisdnWork work = new DeallocateMsisdnWork(msisdn);
		try {
			session.doWork(work);
		} catch(HibernateException se) {
			log.error(se);
			handleException(se);
		} 
		if(work.getReturnVal().intValue() != 0) throw new BSCSValidationException(work.getReturnVal());	
	}
	
	public List<String> getFreeMsisdn(final long offset) throws BSCSValidationException {
		GetFreeMsisdnWork work = new GetFreeMsisdnWork((int)offset);
		try {
			session.doWork(work);
		} catch(HibernateException se) {
			log.error(se);
			handleException(se);
		} 
		return work.getReturnVal();
	}
}

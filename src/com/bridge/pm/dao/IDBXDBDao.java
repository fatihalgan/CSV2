package com.bridge.pm.dao;

import java.util.List;

import javax.ejb.Local;

import com.bridge.pm.domain.BSCSValidationException;

import csv.util.persistence.IBaseDao;

@Local
public interface IDBXDBDao extends IBaseDao {

	public void allocateResource(final String imsi, final String sim, final String msisdn) throws BSCSValidationException;
	public void deallocateResource(final String imsi, final String sim, final String msisdn) throws BSCSValidationException;
	public void checkImsi(final String imsi) throws BSCSValidationException;
	public String getImsiForSim(final String sim) throws BSCSValidationException;
	public void allocateMsisdn(final String msisdn) throws BSCSValidationException;
	public void deallocateMsisdn(final String msisdn) throws BSCSValidationException;
	public List<String> getFreeMsisdn(final long offset) throws BSCSValidationException;
}

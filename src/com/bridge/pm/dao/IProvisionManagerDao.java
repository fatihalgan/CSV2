package com.bridge.pm.dao;

import java.util.List;

import javax.ejb.Local;

import com.bridge.pm.domain.ActiveProvisioning;

import csv.util.persistence.IBaseDao;

@Local
public interface IProvisionManagerDao extends IBaseDao {
	public ActiveProvisioning findActiveProvisioning(String msisdn);
	public List<ActiveProvisioning> findActiveProvisioningsByImsi(String imsi);
	public boolean hasActiveProvisioning(String msisdn);
	public Long fetchProvisioningRequestId();
}

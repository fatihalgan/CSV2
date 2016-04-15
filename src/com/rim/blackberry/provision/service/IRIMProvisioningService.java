package com.rim.blackberry.provision.service;

import javax.ejb.Local;

import org.jboss.seam.annotations.async.Asynchronous;
import org.jboss.seam.annotations.async.IntervalCron;
import org.jboss.seam.async.QuartzTriggerHandle;

@Local
public interface IRIMProvisioningService {
	
	@Asynchronous
	public QuartzTriggerHandle processRIMEvents(@IntervalCron String cron);

}

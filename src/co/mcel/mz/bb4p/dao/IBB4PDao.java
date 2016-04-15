package co.mcel.mz.bb4p.dao;

import java.util.List;

import javax.ejb.Local;

import co.mcel.mz.bb4p.model.BB4PReservation;
import csv.util.persistence.IBaseDao;

@Local
public interface IBB4PDao extends IBaseDao {

	public List<BB4PReservation> getReservations(String msisdn);
}

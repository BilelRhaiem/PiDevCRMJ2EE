package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Period;

@Remote
public interface PeriodServiceRemote {

	
	public int addPeriod(Period p);
	public void updatePeriod(Period p);
	public void deletePerioById(int IdPeriod);
	public Period getPeriodById(int IdPeriod);
	public List<Period> getAllPeriod();

}

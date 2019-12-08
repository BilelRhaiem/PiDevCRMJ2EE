package Interfaces;

import javax.ejb.Local;

import model.Forfait;

@Local
public interface ForfaitServiceLocal {
	public int addForfait(Forfait o);

}

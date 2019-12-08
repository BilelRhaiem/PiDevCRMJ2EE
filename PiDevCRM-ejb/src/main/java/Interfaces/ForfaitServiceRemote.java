package Interfaces;

import javax.ejb.Remote;

import model.Forfait;

@Remote
public interface ForfaitServiceRemote {
	public int addForfait(Forfait o);
}

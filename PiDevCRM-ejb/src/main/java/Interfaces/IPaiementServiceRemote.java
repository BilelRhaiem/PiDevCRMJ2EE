package Interfaces;

import javax.ejb.Remote;

import model.Paiement;



@Remote
public interface IPaiementServiceRemote {
	public Paiement getPaiementByNumlAndCodeSecretd(int num, String code); 
}

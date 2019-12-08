package Implimentation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Interfaces.IPaiementServiceRemote;
import model.Client;
import model.Paiement;

@Stateless
@LocalBean
public class PaiementService implements IPaiementServiceRemote{
	
	@PersistenceContext(unitName="primary")
	EntityManager em;

	@Override
	public Paiement getPaiementByNumlAndCodeSecretd(int numCarte, String codeSecret) {
		TypedQuery<Paiement> query = 
				em.createQuery("select e from Paiement e WHERE e.numCarte=:numCarte and e.codeSecret=:codeSecret ", Paiement.class);
		query.setParameter("numCarte", numCarte); 
		query.setParameter("codeSecret", codeSecret); 
		Paiement paiement = null; 
		try {
			paiement = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return paiement;
	}

}

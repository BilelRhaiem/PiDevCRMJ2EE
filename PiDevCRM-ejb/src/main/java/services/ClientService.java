package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import interfaces.IClientServiceRemote;
import model.Client;

@Stateless
@LocalBean
public class ClientService implements IClientServiceRemote {
	
	@PersistenceContext(unitName="pi")
	EntityManager em;

	@Override
	public Client getClientByEmailAndPassword(String email, String password) {
	 TypedQuery<Client> query =
			 em.createQuery("select e from Client e WHERE e.email=:email and e.password=:password",Client.class);
		     query.setParameter("email", email);
		     query.setParameter("password", password);
		     Client client =null;
		     try {
		    	 client =query.getSingleResult();
		     }
		     catch(Exception e) {
		    	 System.out.println("Erreur:" + e);
		     }
		     return client;
	}
	
	

}

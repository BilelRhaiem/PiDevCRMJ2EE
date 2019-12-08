package Implimentation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Interfaces.ClientServiceRemote;
import model.Client;
import model.Offre;


@Stateless
@LocalBean
public class ClientService implements ClientServiceRemote {

	@PersistenceContext(unitName="primary")
	EntityManager em;
	
	@Override
	public Client getEmployeByEmailAndPassword(String email, String password) {
		TypedQuery<Client> query = 
				em.createQuery("select e from Client e WHERE e.email=:email and e.password=:password ", Client.class); 
				query.setParameter("email", email); 
				query.setParameter("password", password); 
				Client client = null; 
				try {
					client = query.getSingleResult(); 
				}
				catch (Exception e) {
					System.out.println("Erreur : " + e);
				}
				return client;
	}

	@Override
	public Client getClientById(int IdClient) {
		TypedQuery<Client> query = em.createQuery("select o from Client o where o.idClient=:IdClient", Client.class);
		query.setParameter("idClient", IdClient);
		Client client = null;
		try {
			client = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}

		return client;
	}

}

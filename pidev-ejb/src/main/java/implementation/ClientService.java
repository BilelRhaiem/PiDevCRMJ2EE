package implementation;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Services.ClientServiceRemote;
import model.Client;

@Stateless
@LocalBean

public class ClientService implements ClientServiceRemote {

	@PersistenceContext
	EntityManager em;
	
	public int ajouterClient(Client client) {
		em.persist(client);
		return client.getIdClient();
	}

	@Override
	public void supprimerClientById(int Id) {
		Client client = em.find(Client.class,Id);
		em.remove(client);
	}

	@Override
	public void updateClient(Client client) {
		Client c = em.find(Client.class,client.getIdClient());
		c.setEmail(client.getEmail());
		c.setName(client.getName());
		c.setLastName(client.getLastName());
		c.setPassword(client.getPassword());
		c.setPhoneNumber(client.getPhoneNumber());
	}

	@Override
	public List<Client> getAllClient() {
		TypedQuery<Client> clients = em.createQuery("SELECT c FROM Client c",Client.class);
		List<Client> clientsRes = clients.getResultList();
		return clientsRes;
	}
	
	public Integer getAllClientPhyisque(){
		TypedQuery<Client> clientPhysiques = em.createQuery("Select c from Client c where c.clientType=1",Client.class);
		List<Client> clientPhysiquesRes = clientPhysiques.getResultList();
		return clientPhysiques.getResultList().size();
	}
	
	public Integer getAllEntreprise(){
		TypedQuery<Client> clientPhysiques = em.createQuery("Select c from Client c where c.clientType=0",Client.class);
		List<Client> clientPhysiquesRes = clientPhysiques.getResultList();
		return clientPhysiques.getResultList().size();
	}

	@Override
	public Client getClientByEmailAndPassword(String email, String password) {
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
	

	
	
	
}

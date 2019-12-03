package Services;



import java.util.List;

import javax.ejb.Remote;

import model.Client;

@Remote
public interface ClientServiceRemote {

	public int ajouterClient(Client client);
	public void supprimerClientById(int Id);
	public void updateClient(Client client);
	public List<Client> getAllClient();
	
	
}

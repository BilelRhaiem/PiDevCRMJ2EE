package interfaces;

import javax.ejb.Remote;

import model.Client;

@Remote
public interface IClientServiceRemote {
	public Client getClientByEmailAndPassword(String email, String password);

}

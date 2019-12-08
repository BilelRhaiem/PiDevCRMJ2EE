package Interfaces;

import javax.ejb.Remote;

import model.Client;

@Remote
public interface ClientServiceRemote {

	
	public Client getEmployeByEmailAndPassword(String email, String password); 
	public Client getClientById(int IdClient);

}

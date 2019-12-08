package Interfaces;

import javax.ejb.Remote;

import model.Client;

@Remote
public interface IClientServiceRemote {
	public Client getEmployeByEmailAndPassword(String email, String password); 
}

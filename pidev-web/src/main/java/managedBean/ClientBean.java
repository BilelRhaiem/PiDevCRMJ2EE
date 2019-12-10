package managedBean;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import implementation.ClientService;
import model.Client;

@ManagedBean(name="clientBean")
@SessionScoped

public class ClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date birthDate;
	private int clientType;
	private String email;
	private String lastName;
	private String Name;
	private String password;
	private String phoneNumber;
	private List<Client> clients;
	private int clientIdToBeUpdated;
	private Client client;

	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	@EJB
	ClientService cs ;
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public int getClientIdToBeUpdated() {
		return clientIdToBeUpdated;
	}
	public void setClientIdToBeUpdated(int clientIdToBeUpdated) {
		this.clientIdToBeUpdated = clientIdToBeUpdated;
	}
	public int getClientType() {
		return clientType;
	}
	public void setClientType(int clientType) {
		this.clientType = clientType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

	
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public void addClient(){
		Client c = new Client(birthDate, email, lastName, Name, password, phoneNumber);
		c.setClientType(1);
		cs.ajouterClient(c);
		
		
	}
	
	public void deleteClient(int id) {
		cs.supprimerClientById(id);
	}
	
	public List<Client> getAllClient(){
		clients = cs.getAllClient();
		return clients;
	}
	
	public String displayClient(Client c) {
		String navigateTo=null;
		navigateTo="/updateClient?faces-redirect=true";
		this.setName(c.getName());
		this.setLastName(c.getLastName());
		this.setPassword(c.getPassword());
		this.setEmail(c.getEmail());
		this.setClientIdToBeUpdated(c.getIdClient());
		return navigateTo;
	}
	
	public String updateClient() {
		String navigateTo=null;
		navigateTo="/AdminHome?faces-redirect=true";
		Client c = new Client(clientIdToBeUpdated, email, lastName, Name, password, phoneNumber);
		cs.updateClient(c);
		return navigateTo;
		
	}
	
}

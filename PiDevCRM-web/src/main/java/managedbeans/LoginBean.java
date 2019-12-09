package managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Implimentation.ClientService;
import model.Client;

@ManagedBean
@SessionScoped
public class LoginBean  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String email; 
	private String password; 
	private Client client; 
	private Boolean loggedIn;
	
	@EJB
	ClientService Cservice;
	
	public String doLogin() {
		String navigateTo= "null";
		client= Cservice.getEmployeByEmailAndPassword(email, password);
		if(client!= null&& client.getClientType().equals("Entreprise")) {
		navigateTo= "/OffersViews/EntrepriseViews/ListOffresEntreprise?faces-redirect=true";
		loggedIn= true; 
		}
		else if(client!= null&& client.getClientType().equals("Client_Physique")) {
			navigateTo= "/OffersViews/ClientPhysiqueViews/ListOffresClientPhysique?faces-redirect=true";
			loggedIn= true; 
			}
		else if(client!= null&& client.getClientType().equals("Admin")) {
			navigateTo= "/pages/admin/AdminHome?faces-redirect=true";
			loggedIn= true; 
			}
		else{
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
		return navigateTo;
		}
	
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"/Login?faces-redirect=true"; }
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	

}

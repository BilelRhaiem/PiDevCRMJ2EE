package managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Client;
import services.ClientService;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private Client client; 
	private Boolean loggedIn;
	
	@EJB
	ClientService clientService;

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

	

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LoginBean() {
		super();
	}
	
	public String doLogin() {
		String navigateTo = "null";
		client = clientService.getClientByEmailAndPassword(email, password);
		if (client != null && client.getClientType().equals("Client")) {
			navigateTo = "/pages/rendezVous/ajouterRendezVous?faces-redirect=true"; loggedIn = true; }
		else if (client != null && client.getClientType().equals("Admin")) {
			navigateTo = "/pages/rendezVous/listeRendezVous?faces-redirect=true"; loggedIn = true; }
		
		
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
		return navigateTo; }
	
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true"; }
	}

	
	


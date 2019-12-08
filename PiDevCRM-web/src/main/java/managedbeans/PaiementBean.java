package managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import Implimentation.PaiementService;
import model.Paiement;

@ManagedBean(name = "paiementBean") 
@SessionScoped
public class PaiementBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int numCarte;

	private String codeSecret;
	
	private String nom ;
	
	private String prenom;
	
	private float Title;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public float getTitle() {
		return Title;
	}

	public void setTitle(float title) {
		Title = title;
	}

	private Paiement paiement; 
	
	private Boolean loggedIn;
	
	@EJB
	PaiementService Cservice;
	
	public String doPaiement() {
		String navigateTo= "null";
		paiement= (Paiement) Cservice.getPaiementByNumlAndCodeSecretd(numCarte,codeSecret);
		if(paiement!= null) {
		navigateTo= "/OuiPaiement?faces-redirect=true";
		loggedIn= true; 
		}
	
	
		else{
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		navigateTo= "/NonPaiement?faces-redirect=true";
		}
		return navigateTo;
		}

	public int getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}

	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		this.codeSecret = codeSecret;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


}

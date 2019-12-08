package managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.persistence.Column;

import Implimentation.ForfaitService;
import model.Forfait;

@ManagedBean(name = "forfaitBean") 
@SessionScoped
public class ForfaitBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long contact;

	private int montant;

	private int nbrMega;

	private String typePaiement;
	
	@EJB 
	ForfaitService forfaitService; 
	public String addForfait() {
		forfaitService.addForfait(new Forfait(contact,montant,nbrMega,typePaiement)); 
		String navigateTo= "null";
		navigateTo= "/ForfaitDetail?faces-redirect=true";
		return navigateTo;
	}
	
	public String goPaiement() {
		String navigateTo= "null";
		navigateTo= "/FormulairePaiement?faces-redirect=true";
		return navigateTo;
	}
	
	public String goDetail() {
		String navigateTo= "null";
		navigateTo= "/addForfaitFinal?faces-redirect=true";
		return navigateTo;
	}
	
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public int getNbrMega() {
		return nbrMega;
	}
	public void setNbrMega(int nbrMega) {
		this.nbrMega = nbrMega;
	}
	public String getTypePaiement() {
		return typePaiement;
	}
	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

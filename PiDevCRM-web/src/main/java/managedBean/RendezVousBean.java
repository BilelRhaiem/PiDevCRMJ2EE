package managedBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.CauseRendezVous;
import model.Client;
import model.Conf;
import model.RendezVous;
import services.RendezVousService;

@ManagedBean(name = "rendezVousBean")
@SessionScoped
public class RendezVousBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int id;
	private CauseRendezVous causeRendezVous;
	private Conf confirmation;
	private Date demandeDate;
	private Date rendezVousDate;
	private String sujet;
	private Client client;

	@EJB
	RendezVousService rendezVousService;

	public RendezVousBean() {
		super();
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public CauseRendezVous getCauseRendezVous() {
		return causeRendezVous;
	}

	public void setCauseRendezVous(CauseRendezVous causeRendezVous) {
		this.causeRendezVous = causeRendezVous;
	}

	public Conf getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(Conf confirmation) {
		this.confirmation = confirmation;
	}

	public Date getDemandeDate() {
		return demandeDate;
	}

	public void setDemandeDate(Date demandeDate) {
		this.demandeDate = demandeDate;
	}

	public Date getRendezVousDate() {
		return rendezVousDate;
	}

	public void setRendezVousDate(Date rendezVousDate) {
		this.rendezVousDate = rendezVousDate;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private List<RendezVous> rendezVous;

	public void addRendezVous() {
		rendezVousService.ajouterRendezVous(new RendezVous(causeRendezVous, demandeDate, sujet));
	}

	public List<RendezVous> getRendezVous() {
		rendezVous = rendezVousService.getAllRendezVous();
		return rendezVous;
	}

	public void removeRendezVous(int idRendezVous) {
		rendezVousService.deleteRendezVousById(idRendezVous);
	}

	public void displayRendezVous(RendezVous empl) {
		this.setCauseRendezVous(empl.getCauseRendezVous());
		this.setDemandeDate(empl.getDemandeDate());
		this.setSujet(empl.getSujet());

	}

	public void displayRendezVousAdmin(RendezVous empl) {
		id=empl.getIdRendezVous();
		this.setCauseRendezVous(empl.getCauseRendezVous());
		this.setSujet(empl.getSujet());
		this.setDemandeDate(empl.getDemandeDate());
		this.setConfirmation(empl.getConfirmation());
		this.setRendezVousDate(empl.getRendezVousDate());

	}

	public void updateRendezVous() {
		RendezVous rv = new RendezVous();
		rv.setCauseRendezVous(rv.getCauseRendezVous());
		rv.setConfirmation(confirmation);
		rv.setDemandeDate(rv.getDemandeDate());
		rv.setRendezVousDate(rendezVousDate);
		rv.setSujet(rv.getSujet());
		//rv.setIdRendezVous(rv.getIdRendezVous());
		System.out.println(rv);
		rendezVousService
				.updateRendezVous(id,rv);
	}

	public void updateRendezVousClient() {
		rendezVousService.updateRendezVousClient(new RendezVous(causeRendezVous, demandeDate, sujet));
	}

}

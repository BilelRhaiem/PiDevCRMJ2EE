package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the RendezVous database table.
 * 
 */
@Entity
@NamedQuery(name="RendezVous.findAll", query="SELECT r FROM RendezVous r")
public class RendezVous implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdRendezVous")
	private int idRendezVous;
	
	@Column(name="CauseRendezVous")
	@Enumerated(EnumType.ORDINAL)
	private CauseRendezVous causeRendezVous;

	@Column(name="Confirmation")
	@Enumerated(EnumType.ORDINAL)
	private Conf confirmation;

	private Date demandeDate;

	@Column(name="RendezVousDate")
	private Date rendezVousDate;

	@Column(name="Sujet")
	private String sujet;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="IdClient")
	private Client client;

	public RendezVous() {
	}

	public int getIdRendezVous() {
		return this.idRendezVous;
	}

	public void setIdRendezVous(int idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

	public CauseRendezVous getCauseRendezVous() {
		return this.causeRendezVous;
	}

	public void setCauseRendezVous(CauseRendezVous causeRendezVous) {
		this.causeRendezVous = causeRendezVous;
	}

	public Conf getConfirmation() {
		return this.confirmation;
	}

	public void setConfirmation(Conf confirmation) {
		this.confirmation = confirmation;
	}

	public Date getDemandeDate() {
		return this.demandeDate;
	}

	public void setDemandeDate(Date demandeDate) {
		this.demandeDate = demandeDate;
	}

	public Date getRendezVousDate() {
		return this.rendezVousDate;
	}

	public void setRendezVousDate(Date rendezVousDate) {
		this.rendezVousDate = rendezVousDate;
	}

	public String getSujet() {
		return this.sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public RendezVous(CauseRendezVous causeRendezVous, Date demandeDate, String sujet) {
		super();
		this.causeRendezVous = causeRendezVous;
		this.demandeDate = demandeDate;
		this.sujet = sujet;
	}
	

	public RendezVous(int id,CauseRendezVous causeRendezVous, Conf confirmation, Date demandeDate, Date rendezVousDate,
			String sujet) {
		this.idRendezVous=id;
		this.causeRendezVous = causeRendezVous;
		this.confirmation = confirmation;
		this.demandeDate = demandeDate;
		this.rendezVousDate = rendezVousDate;
		this.sujet = sujet;
	}

	public RendezVous(CauseRendezVous causeRendezVous, Conf confirmation, Date demandeDate, Date rendezVousDate,
			String sujet, Client client) {
		super();
		this.causeRendezVous = causeRendezVous;
		this.confirmation = confirmation;
		this.demandeDate = demandeDate;
		this.rendezVousDate = rendezVousDate;
		this.sujet = sujet;
		this.client = client;
	}

	public RendezVous(Conf confirmation, Date rendezVousDate) {
		super();
		this.confirmation = confirmation;
		this.rendezVousDate = rendezVousDate;
	}

	public RendezVous(Conf confirmation, Date demandeDate, Date rendezVousDate) {
		super();
		this.confirmation = confirmation;
		this.demandeDate = demandeDate;
		this.rendezVousDate = rendezVousDate;
		
	}

	@Override
	public String toString() {
		return "RendezVous [idRendezVous=" + idRendezVous + ", causeRendezVous=" + causeRendezVous + ", confirmation="
				+ confirmation + ", demandeDate=" + demandeDate + "]";
	}
	
	
	

}
package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Offres database table.
 * 
 */
@Entity
@Table(name="Offres")
@NamedQuery(name="Offre.findAll", query="SELECT o FROM Offre o")
public class Offre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdOffre")
	private int idOffre;

	@Enumerated(EnumType.STRING)
	private CategoryClient categoryClient;

	@Column(name="Demande")
	private int demande;

	@Column(name="Description")
	private String description;

	@Column(name="OffreImage")
	private String offreImage;

	@Column(name="PriceOffer")
	private float priceOffer;

	@Column(name="Title")
	private String title;

	//bi-directional many-to-many association to Client
	@ManyToMany
	@JoinTable(
		name="OffreClients"
		, joinColumns={
			@JoinColumn(name="Offre_IdOffre")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Client_IdClient")
			}
		)
	private List<Client> clients;

	//bi-directional many-to-one association to Period
	@ManyToOne
	@JoinColumn(name="IdPeriod")
	private Period period;



	public Offre() {
	}

	public int getIdOffre() {
		return this.idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}

	

	public CategoryClient getCategoryClient() {
		return categoryClient;
	}

	public void setCategoryClient(CategoryClient categoryClient) {
		this.categoryClient = categoryClient;
	}

	public int getDemande() {
		return this.demande;
	}

	public void setDemande(int demande) {
		this.demande = demande;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOffreImage() {
		return this.offreImage;
	}

	public void setOffreImage(String offreImage) {
		this.offreImage = offreImage;
	}

	public float getPriceOffer() {
		return this.priceOffer;
	}

	public void setPriceOffer(float priceOffer) {
		this.priceOffer = priceOffer;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Period getPeriod() {
		return this.period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Offre(CategoryClient categoryClient, int demande, String description, String offreImage, float priceOffer,
			String title, Period period) {
		super();
		this.categoryClient = categoryClient;
		this.demande = demande;
		this.description = description;
		this.offreImage = offreImage;
		this.priceOffer = priceOffer;
		this.title = title;
		this.period = period;
	}

	public Offre(int idOffre, CategoryClient categoryClient, String description, float priceOffer, String title) {
		super();
		this.idOffre = idOffre;
		this.categoryClient = categoryClient;
		this.description = description;
		this.priceOffer = priceOffer;
		this.title = title;
	}

	public Offre(CategoryClient categoryClient, String description, String offreImage, float priceOffer, String title) {
		super();
		this.categoryClient = categoryClient;
		this.description = description;
		this.offreImage = offreImage;
		this.priceOffer = priceOffer;
		this.title = title;
		
	}

	@Override
	public String toString() {
		return "Offre [idOffre=" + idOffre + ", categoryClient=" + categoryClient + ", demande=" + demande
				+ ", description=" + description + ", offreImage=" + offreImage + ", priceOffer=" + priceOffer
				+ ", title=" + title + ",+ , period=" + period + "]";
	}

	
	
}
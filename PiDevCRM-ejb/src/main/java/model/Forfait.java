package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Forfaits database table.
 * 
 */
@Entity
@Table(name="Forfaits")
@NamedQuery(name="Forfait.findAll", query="SELECT f FROM Forfait f")
public class Forfait implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdForfait")
	private int idForfait;

	@Column(name="Contact")
	private long contact;

	@Column(name="Montant")
	private int montant;

	private int nbrMega;

	private String typePaiement;

	//bi-directional many-to-one association to Paiement
	@ManyToOne
	@JoinColumn(name="idPaiement")
	private Paiement paiement;

	public Forfait() {
	}

	public int getIdForfait() {
		return this.idForfait;
	}

	public void setIdForfait(int idForfait) {
		this.idForfait = idForfait;
	}

	public long getContact() {
		return this.contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public int getMontant() {
		return this.montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public int getNbrMega() {
		return this.nbrMega;
	}

	public void setNbrMega(int nbrMega) {
		this.nbrMega = nbrMega;
	}

	public String getTypePaiement() {
		return this.typePaiement;
	}

	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}

	public Forfait(long contact, int montant, int nbrMega, String typePaiement) {
		super();
		this.contact = contact;
		this.montant = montant;
		this.nbrMega = nbrMega;
		this.typePaiement = typePaiement;
	}

	public Paiement getPaiement() {
		return this.paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

}
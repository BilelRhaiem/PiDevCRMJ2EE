package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Paiements database table.
 * 
 */
@Entity
@Table(name="Paiements")
@NamedQuery(name="Paiement.findAll", query="SELECT p FROM Paiement p")
public class Paiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numCarte;

	private String codeSecret;

	private String nom;

	private String prenom;

	@Column(name="Title")
	private float title;

	//bi-directional many-to-one association to Forfait
	@OneToMany(mappedBy="paiement")
	private List<Forfait> forfaits;

	public Paiement() {
	}

	public int getNumCarte() {
		return this.numCarte;
	}

	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}

	public String getCodeSecret() {
		return this.codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		this.codeSecret = codeSecret;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public float getTitle() {
		return this.title;
	}

	public void setTitle(float title) {
		this.title = title;
	}

	public List<Forfait> getForfaits() {
		return this.forfaits;
	}

	public void setForfaits(List<Forfait> forfaits) {
		this.forfaits = forfaits;
	}

	public Forfait addForfait(Forfait forfait) {
		getForfaits().add(forfait);
		forfait.setPaiement(this);

		return forfait;
	}

	public Forfait removeForfait(Forfait forfait) {
		getForfaits().remove(forfait);
		forfait.setPaiement(null);

		return forfait;
	}

}
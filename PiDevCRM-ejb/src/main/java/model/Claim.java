package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the Claims database table.
 * 
 */
@Entity
@Table(name="Claims")
@NamedQuery(name="Claim.findAll", query="SELECT c FROM Claim c")
public class Claim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdClaims")
	private int idClaims;

	@Column(name="Answer")
	private String answer;

	@Column(name="ClaimDate")
	private Date claimDate;

	@Column(name="Description")
	private String description;

	private int statustype;

	private int typeClaims;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="IdClient")
	private Client client;

	public Claim() {
	}

	public int getIdClaims() {
		return this.idClaims;
	}

	public void setIdClaims(int idClaims) {
		this.idClaims = idClaims;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getClaimDate() {
		return this.claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatustype() {
		return this.statustype;
	}

	public void setStatustype(int statustype) {
		this.statustype = statustype;
	}

	public int getTypeClaims() {
		return this.typeClaims;
	}

	public void setTypeClaims(int typeClaims) {
		this.typeClaims = typeClaims;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
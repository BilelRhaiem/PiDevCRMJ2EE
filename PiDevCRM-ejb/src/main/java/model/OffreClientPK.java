package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the OffreClients database table.
 * 
 */
@Embeddable
public class OffreClientPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Offre_IdOffre", insertable=false, updatable=false)
	private int offre_IdOffre;

	@Column(name="Client_IdClient", insertable=false, updatable=false)
	private int client_IdClient;

	public OffreClientPK() {
	}
	public int getOffre_IdOffre() {
		return this.offre_IdOffre;
	}
	public void setOffre_IdOffre(int offre_IdOffre) {
		this.offre_IdOffre = offre_IdOffre;
	}
	public int getClient_IdClient() {
		return this.client_IdClient;
	}
	public void setClient_IdClient(int client_IdClient) {
		this.client_IdClient = client_IdClient;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OffreClientPK)) {
			return false;
		}
		OffreClientPK castOther = (OffreClientPK)other;
		return 
			(this.offre_IdOffre == castOther.offre_IdOffre)
			&& (this.client_IdClient == castOther.client_IdClient);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.offre_IdOffre;
		hash = hash * prime + this.client_IdClient;
		
		return hash;
	}
}
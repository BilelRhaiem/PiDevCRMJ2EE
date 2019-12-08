package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OffreClients database table.
 * 
 */
@Entity
@Table(name="OffreClients")
@NamedQuery(name="OffreClient.findAll", query="SELECT o FROM OffreClient o")
public class OffreClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OffreClientPK id;

	public OffreClient() {
	}

	public OffreClientPK getId() {
		return this.id;
	}

	public void setId(OffreClientPK id) {
		this.id = id;
	}

}
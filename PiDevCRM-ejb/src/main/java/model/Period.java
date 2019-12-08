package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Periods database table.
 * 
 */
@Entity
@Table(name="Periods")
@NamedQuery(name="Period.findAll", query="SELECT p FROM Period p")
public class Period implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdPeriod")
	private int idPeriod;

	@Column(name="EndDate")
	private Date endDate;

	@Column(name="StartDate")
	private Date startDate;

	@Column(name="TitlePeriod")
	private String titlePeriod;

	//bi-directional many-to-one association to Offre
	@OneToMany(mappedBy="period")
	private List<Offre> offres;


	public Period() {
	}

	public int getIdPeriod() {
		return this.idPeriod;
	}

	public void setIdPeriod(int idPeriod) {
		this.idPeriod = idPeriod;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTitlePeriod() {
		return this.titlePeriod;
	}

	public void setTitlePeriod(String titlePeriod) {
		this.titlePeriod = titlePeriod;
	}

	public List<Offre> getOffres() {
		return this.offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public Offre addOffres(Offre offres) {
		getOffres().add(offres);
		offres.setPeriod(this);

		return offres;
	}

	public Offre removeOffres(Offre offres) {
		getOffres().remove(offres);
		offres.setPeriod(null);

		return offres;
	}

	public Period(Date endDate, Date startDate) {
		super();
		this.endDate = endDate;
		this.startDate = startDate;
	}

	public Period(int idPeriod, Date endDate, Date startDate) {
		super();
		this.idPeriod = idPeriod;
		this.endDate = endDate;
		this.startDate = startDate;
	}

	public Period(Date endDate, Date startDate, String titlePeriod) {
		super();
		this.endDate = endDate;
		this.startDate = startDate;
		this.titlePeriod = titlePeriod;
	}

	public Period(int idPeriod, Date endDate, Date startDate, String titlePeriod) {
		super();
		this.idPeriod = idPeriod;
		this.endDate = endDate;
		this.startDate = startDate;
		this.titlePeriod = titlePeriod;
	}


}
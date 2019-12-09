package managedbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import Implimentation.ClientService;
import Implimentation.DemandeOffreClient;
import Implimentation.OfferService;
import Implimentation.PeriodService;
import model.Offre;
import model.OffreClient;
import model.OffreClientPK;
import model.Period;
import model.CategoryClient;
import model.Client;
import utils.Util;

@ManagedBean(name = "offersBean")
@SessionScoped
public class OffersBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean clicked;
	private String header;
	private String name;
	private String mailAddress;
	private boolean demanded;
	private Date StartDate;
	private Date EndDate;
	private OffreClientPK offcPK;
	private OffreClient offc;
	private String Title;
	private String Description;
	private Part file;
	private Client client;
	private int OfferIdToBeUpdated;
	private float PriceOffer;
	private CategoryClient CategoryClient;
	private List<Offre> Loffs;
	private int Demande;
	private Offre Offre;
	private int SelectPeriodById;
	private Period period;
	private int IdOffre;
	private int Client_IdClient;

	@EJB
	OfferService Oservice;

	@EJB
	PeriodService Pservice;

	@EJB
	DemandeOffreClient Demservice;

	@EJB
	ClientService Cservice;

	public String movetoAdd() {
		String navigateTo = "null";
		navigateTo = "/AddOffer?faces-redirect=true";
		return navigateTo;

	}

	//long diff = StartDate.getTime() - EndDate.getTime();
	//float res = (diff / (1000 * 60 * 60 * 24));
	//int value = (int) res;

	public String ViewOffreDeatilsAdmin(Offre off) {
		String navigateTo = "null";
		Oservice.updateDemandeOffre(off);
		Long count = Oservice.NberDemandeOffre(off.getIdOffre());
		int i = count.intValue();
		System.out.println(i);
		navigateTo = "/pages/admin/OffreDetailsAdmin?faces-redirect=true";
		this.setTitle(off.getTitle());
		this.setDescription(off.getDescription());
		this.setDemande(i);
		this.setPriceOffer(off.getPriceOffer());
		this.setIdOffre(off.getIdOffre());
		return navigateTo;
	}

	public String ViewOffreDeatilsClient(Offre off) {
		String navigateTo = "null";
		navigateTo = "/OffersViews/ClientPhysiqueViews/DemandDeatilsOffreClientPhysique?faces-redirect=true";
		this.setTitle(off.getTitle());
		this.setDescription(off.getDescription());
		this.setPriceOffer(off.getPriceOffer());
		this.setIdOffre(off.getIdOffre());
		return navigateTo;
	}

	public String ViewOfferList() {
		String navigateTo = "null";
		navigateTo = "/pages/admin/ListOffreAdmin?faces-redirect=true";
		return navigateTo;
	}

	public String ViewDemandedOfferList() {
		String navigateTo = "null";

		navigateTo = "/pages/admin/ListOffreDemandeAdmin?faces-redirect=true";
		return navigateTo;
	}

	public String ViewOfferListEntreprise() {
		String navigateTo = "null";
		navigateTo = "/OffersViews/EntrepriseViews/ListOffresEntreprise?faces-redirect=true";
		return navigateTo;
	}

	public String ViewOfferListClient() {
		String navigateTo = "null";
		navigateTo = "/OffersViews/ClientPhysiqueViews/ListOffresClientPhysique?faces-redirect=true";
		return navigateTo;
	}

	public String GoHome() {
		String navigateTo = "null";
		navigateTo = "/pages/admin/AdminHome?faces-redirect=true";
		return navigateTo;
	}

	public void displayOffre(Offre off) {
		this.setTitle(off.getTitle());
		this.setDescription(off.getDescription());
		this.setPriceOffer(off.getPriceOffer());
		this.setCategoryClient(off.getCategoryClient());
		this.setOfferIdToBeUpdated(off.getIdOffre());
	}

	public void updateOffre() {
		Period selectedperiod = Pservice.getPeriodById(SelectPeriodById);
		Offre offre = new Offre(OfferIdToBeUpdated, CategoryClient, Description, PriceOffer, Title);
		offre.setPeriod(selectedperiod);
		Oservice.updateOffre(offre);
	}

	public String updateNbrDemandeOffreClient(Offre off) {

		String navigateTo = "null";

		// Oservice.updateDemandeOffre(off);

		navigateTo = "/OffersViews/ClientPhysiqueViews/DemandDeatilsOffreClientPhysique?faces-redirect=true";
		this.setTitle(off.getTitle());
		this.setDescription(off.getDescription());
		this.setPriceOffer(off.getPriceOffer());
		this.setIdOffre(off.getIdOffre());

		return navigateTo;
	}

	public String updateNbrDemandeOffreEntreprise(Offre off) {

		String navigateTo = "null";

		// Oservice.updateDemandeOffre(off);

		navigateTo = "/OffersViews/EntrepriseViews/DemandDeatilsOffreEntreprise?faces-redirect=true";
		this.setTitle(off.getTitle());
		this.setDescription(off.getDescription());
		this.setPriceOffer(off.getPriceOffer());
		this.setIdOffre(off.getIdOffre());

		return navigateTo;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public void returnnumber() {
		System.out.println(Oservice.CountEntreprise());
	}

	public String DemandeOffreClient(int idOffre, int clId) throws IOException {

		String navigateTo = "null";

		this.demanded = true;
		Demservice.ajouterDemande(idOffre, clId);

		Demservice.sendMail(Cservice.getClientById(clId).getEmail(), "Demande offre: " + Title + " " + PriceOffer,
				"Demande offre");
		System.out.println(Cservice.getClientById(clId).getEmail());

		navigateTo = "/OffersViews/ClientPhysiqueViews/ListOffresClientPhysique?faces-redirect=true";
		return navigateTo;

	}

	public String DemandeOffreEntreprise(int idOffre, int clId) {

		String navigateTo = "null";
		this.demanded = true;
		Demservice.ajouterDemande(idOffre, clId);

		// FacesContext.getCurrentInstance().addMessage("form:part", new
		// FacesMessage("Confirm Demande"));

		Demservice.sendMail(Cservice.getClientById(clId).getEmail(), "Demande offre: " + Title + " " + PriceOffer,
				"Demande offre");
		System.out.println(Cservice.getClientById(clId).getEmail() + "111");
		navigateTo = "/OffersViews/EntrepriseViews/ListOffresEntreprise?faces-redirect=true";
		return navigateTo;

	}

	public void addOff() throws IOException {
		Period selectedperiod = Pservice.getPeriodById(SelectPeriodById);
		Offre offre = new Offre(CategoryClient, Description, file.getSubmittedFileName(), PriceOffer, Title);
		offre.setPeriod(selectedperiod);
		Oservice.addOffre(offre);
		String folderName1 = Util.serverI;
		uploadimage(folderName1);
	}

	public List<Offre> getAllOffers() {
		Loffs = Oservice.getAllOffre();
		return Loffs;
	}

	public List<Offre> getAllOffersClientPhysique() {
		Loffs = Oservice.getAllOffreByGategoryClientPhysique();
		return Loffs;
	}

	public List<Offre> getAllOffersEntreprise() {
		Loffs = Oservice.getAllOffreByGategoryEntreprise();
		return Loffs;
	}

	public List<Offre> getAllDemandedOffers() {
		Loffs = Oservice.getAllDemandedOffres();
		System.out.println("infoooooooo     " + Loffs);
		return Loffs;
	}

	public void deleteOffer(int id) {
		Oservice.deleteOffre(id);

	}

	public Offre getSelectedOffre(int id) {

		Oservice.getOffreById(id);

		System.out.println("its working but not like i want");
		return Offre;

	}

	private List<Period> Periods;

	public List<Period> getPeriods() {
		Periods = Pservice.getAllPeriod();
		return Periods;
	}

	public void addPeriod() {

		Pservice.addPeriod(new Period(StartDate, EndDate));
	}

	public String uploadimage(String folderName1) throws IOException {

		if (file != null) {

			InputStream in = file.getInputStream();
			File f = new File(folderName1 + "\\" + file.getSubmittedFileName());
			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			out.close();
			in.close();
			return "succes-image-uplaod?faces-redirect=true";
		} else {
			return "succes-image-uplaod?faces-redirect=true";
		}
	}

	public Date getStartDate() {
		return StartDate;

	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public float getPriceOffer() {
		return PriceOffer;
	}

	public void setPriceOffer(float priceOffer) {
		PriceOffer = priceOffer;
	}

	public CategoryClient getCategoryClient() {
		return CategoryClient;
	}

	public void setCategoryClient(CategoryClient categoryClient) {
		CategoryClient = categoryClient;
	}

	public List<Offre> getLoffs() {
		return Loffs;
	}

	public void setLoffs(List<Offre> loffs) {
		Loffs = loffs;
	}

	public int getDemande() {
		return Demande;
	}

	public void setDemande(int demande) {
		Demande = demande;
	}

	public Offre getOffre() {
		return Offre;
	}

	public void setOffre(Offre offre) {
		Offre = offre;
	}

	public int getSelectPeriodById() {
		return SelectPeriodById;
	}

	public void setSelectPeriodById(int selectPeriodById) {
		this.SelectPeriodById = selectPeriodById;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public void setPeriods(List<Period> periods) {
		Periods = periods;
	}

	public int getOfferIdToBeUpdated() {
		return OfferIdToBeUpdated;
	}

	public void setOfferIdToBeUpdated(int offerIdToBeUpdated) {
		OfferIdToBeUpdated = offerIdToBeUpdated;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OffreClientPK getOffcPK() {
		return offcPK;
	}

	public void setOffcPK(OffreClientPK offcPK) {
		this.offcPK = offcPK;
	}

	public OffreClient getOffc() {
		return offc;
	}

	public void setOffc(OffreClient offc) {
		this.offc = offc;
	}

	public int getIdOffre() {
		return IdOffre;
	}

	public void setIdOffre(int idOffre) {
		IdOffre = idOffre;
	}

	public int getClient_IdClient() {
		return Client_IdClient;
	}

	public void setClient_IdClient(int client_IdClient) {
		Client_IdClient = client_IdClient;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public boolean isDemanded() {
		return demanded;
	}

	public void setDemanded(boolean demanded) {
		this.demanded = demanded;
	}

	public void showcount(int idoff) {

		System.out.println(Oservice.NberDemandeOffre(idoff));
	}

	public String removeDemandeClient(int IdOffre, int IdClient) {
		String navigateTo = null;
		this.demanded = false;
		Demservice.DeleteDemande(IdOffre, IdClient);
		navigateTo = "/OffersViews/ClientPhysiqueViews/ListOffresClientPhysique?faces-redirect=true";
		FacesContext.getCurrentInstance().addMessage("form:delpart", new FacesMessage("Removed!"));
		return navigateTo;
	}

	public String removeDemandeEntreprise(int IdOffre, int IdClient) {
		String navigateTo = null;
		this.demanded = false;
		Demservice.DeleteDemande(IdOffre, IdClient);
		navigateTo = "/OffersViews/EntrepriseViews/ListOffresEntreprise?faces-redirect=true";
		FacesContext.getCurrentInstance().addMessage("form:delpart", new FacesMessage("Removed!"));
		return navigateTo;
	}

	public void recherche() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String text = ec.getRequestParameterMap().get("form:search");
		Loffs = Oservice.getAllOffreByGategory(text);
	}

}

package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Offre;

@Remote
public interface OfferServiceRemote {

	public int addOffre(Offre o);
	public void deleteOffre(int IdOffer);
	public void updateOffre(Offre o);
	public int getOffreById(int IdOffer);
	public List<Offre> getAllOffre();
	public List<Offre> getAllOffreByGategory(String category);
	public List<Offre> getAllOffreByGategoryClientPhysique();
	public List<Offre> getAllOffreByGategoryEntreprise();
	public List<Offre> getOffreByCategory(String category);
	public void updateDemandeOffre(Offre off);
	public Long NberDemandeOffre(int IdOffer);
	public List<Offre> getAllDemandedOffres();
	public Long CountEntreprise();
	
	
	
}

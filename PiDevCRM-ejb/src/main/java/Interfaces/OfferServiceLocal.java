package Interfaces;

import java.util.List;

import javax.ejb.Local;

import model.Offre;

@Local
public interface OfferServiceLocal {

	public int addOffre(Offre o);
	public void deleteOffre(int IdOffer);
	public void updateOffre(Offre o);
	public Offre getOffreById(int IdOffer);
	public List<Offre> getAllOffre();
	public List<Offre> getAllOffreByGategory(String category);
	public Offre getOffreByCategory(String category);
	
}

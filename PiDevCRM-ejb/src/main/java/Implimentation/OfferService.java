package Implimentation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Interfaces.OfferServiceRemote;
import model.Offre;

@Stateless
@LocalBean
public class OfferService implements OfferServiceRemote {
	

	@PersistenceContext(unitName="primary")
	EntityManager em;
	
	@Override
	public int addOffre(Offre o) {
		em.persist(o);
 		return o.getIdOffre();
	}

	@Override
	public void deleteOffre(int IdOffer) {
		Offre o = em.find(Offre.class,IdOffer);
		em.remove(o);
		
	}

	@Override
	public void updateOffre(Offre o) {
		Offre off = em.find(Offre.class, o.getIdOffre()); 
		off.setTitle(o.getTitle()); 
		off.setDescription(o.getDescription());
		off.setCategoryClient(o.getCategoryClient());
		off.setPriceOffer(o.getPriceOffer());
		off.setPeriod(o.getPeriod());

	}
	
	@Override
	public void updateDemandeOffre(Offre off) {

		Query query = em.createQuery("update Offre e set e.demande=:Demande where e.idOffre=:IdOffre");
		query.setParameter("Demande", NberDemandeOffre(off.getIdOffre()).intValue());
		query.setParameter("IdOffre", off.getIdOffre());
		query.executeUpdate();
	}

	

	@Override
	public List<Offre> getAllOffre() {
		
		TypedQuery<Offre> offers = em.createQuery("SELECT f FROM Offre f ", Offre.class);		
		List<Offre> results = offers.getResultList();
		return results; 
	}

	@Override
	public List<Offre> getAllOffreByGategory(String category) {
		TypedQuery<Offre> query = em.createQuery("SELECT Offre.categoryClient from Offre where Offer.categoryClient=:x ", Offre.class);
		query.setParameter("x", category);
		List<Offre> listoffre = new ArrayList<>();
		listoffre = query.getResultList();
		return listoffre;
	}

	@Override
	public Offre getOffreByCategory(String category) {
		TypedQuery<Offre> query = em.createQuery("select o from Offre o where o.categoryClient=:category", Offre.class);
		query.setParameter("categoryClient", category);
		Offre offer = null;
		try {
			offer = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}

		return offer;
	}


	@Override
	public List<Offre> getAllOffreByGategoryClientPhysique() {
		TypedQuery<Offre> query = em.createQuery("SELECT o from Offre o where o.categoryClient='Client_physique' and o.period!=null and o.period.endDate > CURRENT_TIMESTAMP ", Offre.class);
		List<Offre> results = query.getResultList();
		return results; 
	}

	@Override
	public List<Offre> getAllOffreByGategoryEntreprise() {
		TypedQuery<Offre> query = em.createQuery("SELECT o from Offre o where o.categoryClient='Entreprise' and o.period!=null and o.period.endDate > CURRENT_TIMESTAMP", Offre.class);
		List<Offre> results = query.getResultList();
		return results; 
	}

	@Override
	public Long NberDemandeOffre(int IdOffre) {
		TypedQuery<Long> query = em.createQuery("Select DISTINCT count(*) from  OffreClient oc where oc.id.offre_IdOffre=:IdOffre", Long.class);
		
		query.setParameter("IdOffre", IdOffre);		
		return query.getSingleResult();
	
	}

	@Override
	public int getOffreById(int IdOffer) {
		Offre offre = em.find(Offre.class, IdOffer);
		
		return offre.getIdOffre();
	}

	@Override
	public List<Offre> getAllDemandedOffres() {
		TypedQuery<Offre> query = em.createQuery("SELECT o from Offre o, OffreClient oc, Client c where oc.id.offre_IdOffre=o.idOffre and oc.id.client_IdClient=c.idClient", Offre.class);
		List<Offre> results = query.getResultList();
		return results;
	}

	@Override
	public Long CountEntreprise() {

		TypedQuery<Long> query = em.createQuery("select count(*) from Client o where o.clientType='Entreprise'", Long.class);
		return query.getSingleResult();
		
		//return nbr;
	}

	

}

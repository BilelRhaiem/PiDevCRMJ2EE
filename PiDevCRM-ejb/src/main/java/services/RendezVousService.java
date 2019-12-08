package services;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import interfaces.IRendezVousService;

import model.RendezVous;


@Stateless
@LocalBean
public class RendezVousService implements IRendezVousService{

	@PersistenceContext(unitName="pi")
	EntityManager em;
	
	public int ajouterRendezVous(RendezVous rendezVous) 
	{
		em.persist(rendezVous);
		return rendezVous.getIdRendezVous();
	}
	
	@Override
	public List<RendezVous> getAllRendezVous() 
	{ 
		List<RendezVous> emp = em.createQuery("Select e from RendezVous e", RendezVous.class).getResultList(); 
	return emp;
	}

	@Override
	public  void deleteRendezVousById(int idRendezVous) {
		
		System.out.println("In removeUser");
       RendezVous rendez = em.find(RendezVous.class, idRendezVous);
		
        em.remove(rendez);
        System.out.println("out of removeUser");

		
	}

	@Override
	public void updateRendezVous(int id,RendezVous rendezVous) {
		RendezVous emp = em.find(RendezVous.class, id); 
		emp.setCauseRendezVous(rendezVous.getCauseRendezVous());
		emp.setSujet(rendezVous.getSujet());
		emp.setDemandeDate(rendezVous.getDemandeDate());
		
		emp.setConfirmation(rendezVous.getConfirmation());
		emp.setRendezVousDate(rendezVous.getRendezVousDate());
	
	}

	@Override
	public void updateRendezVousClient(RendezVous rendezVous) {

		RendezVous emp = em.find(RendezVous.class, rendezVous.getIdRendezVous()); 
		emp.setCauseRendezVous(rendezVous.getCauseRendezVous());
		emp.setSujet(rendezVous.getSujet());
		emp.setDemandeDate(rendezVous.getDemandeDate());
		
	}
	
	
	
	
	
}

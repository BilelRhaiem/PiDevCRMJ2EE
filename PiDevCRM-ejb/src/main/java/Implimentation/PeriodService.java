package Implimentation;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import Interfaces.PeriodServiceLocal;
import Interfaces.PeriodServiceRemote;
import model.Offre;
import model.Period;

@Stateless
@LocalBean
public class PeriodService implements PeriodServiceLocal,PeriodServiceRemote {

	@PersistenceContext
	EntityManager em;
	
	
	
	
	
	
	@Override
	public int addPeriod(Period p) {
		em.persist(p);
		return p.getIdPeriod();
	}

	@Override
	public void updatePeriod(Period p) {

		Period per = em.find(Period.class, p.getIdPeriod()); 

		per.setTitlePeriod(p.getTitlePeriod());
		per.setStartDate(p.getStartDate());
		per.setEndDate(p.getEndDate());		
	}

	@Override
	public void deletePerioById(int IdPeriod) {
		Period p = em.find(Period.class,IdPeriod);
		List<Offre> offers = p.getOffres();
		 for(Offre o : offers) {
		        o.setPeriod(null);
		    }
		em.remove(p);	
		
	}

	@Override
	public List<Period> getAllPeriod() {
		List<Period> periods = em.createQuery("Select a from Period a", Period.class).getResultList();
		return periods;
	}

	@Override
	public Period getPeriodById(int IdPeriod) {
		TypedQuery<Period> query = em.createQuery("select o from Period o where o.idPeriod=:IdPeriod", Period.class);
		query.setParameter("IdPeriod", IdPeriod);
		Period period = null;
		try {
			period = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}

		return period;
	}

}

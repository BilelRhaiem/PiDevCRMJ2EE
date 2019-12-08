package Implimentation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interfaces.ForfaitServiceLocal;
import Interfaces.ForfaitServiceRemote;
import model.Forfait;

@Stateless
@LocalBean
public class ForfaitService implements ForfaitServiceLocal,ForfaitServiceRemote{
	@PersistenceContext(unitName="primary")
	EntityManager em;
	
	@Override
	public int addForfait(Forfait o) {
		em.persist(o);
 		return o.getIdForfait();
	}
	
}

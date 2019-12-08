package interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.RendezVous;


@Remote
public interface IRendezVousService {

	public int ajouterRendezVous(RendezVous rendezVous);
	public List<RendezVous> getAllRendezVous() ;
	public void deleteRendezVousById(int idRendezVous);
	public void updateRendezVous(int id,RendezVous rendezVous);
	public void updateRendezVousClient(RendezVous rendezVous);
}

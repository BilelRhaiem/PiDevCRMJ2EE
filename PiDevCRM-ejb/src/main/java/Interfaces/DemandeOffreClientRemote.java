package Interfaces;

import javax.ejb.Remote;



@Remote
public interface DemandeOffreClientRemote {

	public void ajouterDemande(int OffreId, int ClientId);
	public boolean checkifDemanded(int IdOffre, int Idclient);
	public void DeleteDemande(int IdOffre,int Idclient);
}

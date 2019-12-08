package managedBean;



import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.CauseRendezVous;
import model.Conf;

@ManagedBean
@ApplicationScoped
public class Data{


	public CauseRendezVous[] getCause() {
		return CauseRendezVous.values();
	}
	
	public Conf[] getConf() {
		return Conf.values();
	}
	
}

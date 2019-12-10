package managedBean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

import implementation.ClientService;

@ManagedBean
public class ChartView implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel;
	@EJB
	ClientService CS;
	
	public long dogetClients() {
		long y = Long.parseLong(CS.getAllClient()+"");
		return y;
	}
	
	public long doGetClientsPhysique() {
		Long x = Long.parseLong(CS.getAllClientPhyisque()+"");
		return x;
	}
	
	public long doGetClientsEntreprise() {
		Long z = Long.parseLong(CS.getAllEntreprise()+"");
		return z;
	}

	public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	private void createPieModel() {
		pieModel = new PieChartModel();
		pieModel.set("Les clients physiques",doGetClientsPhysique());
		pieModel.set("Les clients Entreprises",doGetClientsEntreprise());
		
		pieModel.setTitle("Répartition des clients suivant le type");
		pieModel.setLegendPosition("w");
		pieModel.setShadow(false);
	}
	
	@PostConstruct
    public void init() {
       createPieModel();
    }

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}
	
}

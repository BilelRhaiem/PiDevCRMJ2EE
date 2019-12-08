package managedbeans;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Implimentation.PeriodService;
import model.Period;



@ManagedBean(name = "periodesBean") 
@SessionScoped
public class PeriodesBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public String TitlePeriod;
	private Date StartDate ;
	private Date EndDate ;
	private int SelectedPeriodTobeUpdated;
	private Period period;
	
	public Date newStartDate;
	
	 

	
	@EJB
	PeriodService Pservice;
	
	public Date getTodaysdate() throws ParseException {
	
		String today = java.time.LocalDate.now().toString();  
   	    newStartDate=new SimpleDateFormat("yyyy-MM-dd").parse(today); 
   	    return newStartDate;
	}
	
	public String ViewPeriodList() {
		String navigateTo= "null";
		navigateTo= "/PeriodsViews/ListPeriodsAdmin?faces-redirect=true";
		return navigateTo;
	}
	
	public String addTimezone() {
		String navigateTo= "null";
		navigateTo= "/AddPeriod?faces-redirect=true";
		return navigateTo;
	}
	
	
		private List<Period> Periods;
	public List<Period> getPeriods(){
		Periods = Pservice.getAllPeriod();
		return Periods;
	}
	
     public void addPeriod(){ 
		 Period period =new Period(StartDate,EndDate,TitlePeriod);
		 //String today = java.time.LocalDate.now().toString();
		 if(EndDate.before(StartDate)) {
			 Pservice.addPeriod(period);
		 }
		 else {
			 FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_ERROR,
		               "Invalid start/end dates.",
		               "Start date cannot be after end date.");
		 }
		 
		
		
	}
	
     public void deletePeriod(int id) {
 		Pservice.deletePerioById(id);
 	}

     public void displayPeriod(Period per) {
    	this.setTitlePeriod(per.getTitlePeriod());
 		this.setStartDate(per.getStartDate());
 		this.setEndDate(per.getEndDate());
 		this.setSelectedPeriodTobeUpdated(per.getIdPeriod());
 	}
     
     public void updatePeriod()
 	{ 	
 		Period period = new Period(SelectedPeriodTobeUpdated, StartDate,EndDate,TitlePeriod );
 		if(EndDate.before(StartDate)) {
 		Pservice.updatePeriod(period);
 		}
 		else {
			 FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_ERROR,
		               "Invalid start/end dates.",
		               "Start date cannot be after end date.");
		 }
 		
 	}
     
     
     
     
     
     
     
     
	public int getSelectedPeriodTobeUpdated() {
		return SelectedPeriodTobeUpdated;
	}

	public void setSelectedPeriodTobeUpdated(int selectedPeriodTobeUpdated) {
		SelectedPeriodTobeUpdated = selectedPeriodTobeUpdated;
	}

	public Date getStartDate() {
	return StartDate;
}

public void setStartDate(Date startDate) {
	StartDate = startDate;
}

public Date getEndDate() {
	return EndDate;
}

public void setEndDate(Date endDate) {
	EndDate = endDate;
}

public void setPeriods(List<Period> periods) {
	Periods = periods;
}

public Period getPeriod() {
	return period;
}

public void setPeriod(Period period) {
	this.period = period;
}

public String getTitlePeriod() {
	return TitlePeriod;
}

public void setTitlePeriod(String titlePeriod) {
	TitlePeriod = titlePeriod;
}

	
	
	
	
	
	
}

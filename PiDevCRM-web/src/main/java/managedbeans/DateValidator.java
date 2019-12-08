package managedbeans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateValidator") 
public class DateValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		
       Date startdate = (Date) o;
       Date enddate = (Date) o;
      
		
		if(enddate.before(startdate)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("invalid startDate/endDate");
			message.setDetail("The enddate must be after the startDate");
			throw new ValidatorException(message);
		}
		
	}

}

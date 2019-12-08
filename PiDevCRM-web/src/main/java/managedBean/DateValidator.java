package managedBean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateValidator")
public class DateValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
	
		Date demandeDate = (Date) value;
		Date rendezVousDate =(Date) value;
		
		if(rendezVousDate.before(demandeDate)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("invalid demandeDate/rendezVousDate");
			message.setDetail("the rendezVousDate must be after the demandeDate");
			throw new ValidatorException(message);
		}
		
	}

}

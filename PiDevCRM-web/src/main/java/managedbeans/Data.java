package managedbeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.CategoryClient;




@ManagedBean(name= "data")
@ApplicationScoped
public class Data implements Serializable {

	private static final long serialVersionUID= 1L;
	public CategoryClient[] getCategoryClients() { 
		return CategoryClient.values(); 
		}
	
}

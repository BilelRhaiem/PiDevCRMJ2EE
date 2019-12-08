package managedbeans;

import java.time.LocalDate;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.Client;
import model.Offre;

@ManagedBean(name="mailBean")
@RequestScoped
public class MailBean {

	private String header;
	private String name;
	private String mailAddress;
	private Offre offre;
	private Client client;
	
	
	String today = LocalDate.now().toString();
	
	public void sendMail() {
		final String username = "mohamedamine.elhaddad@esprit.tn";
		final String password = "183JMT0057";
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp", "587");
	Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}}

			);
	try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("mohamedamine.elhaddad@esprit.tn"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("haddadaminou@gmail.com"));
		message.setSubject("demande offre");
		message.setText("offre details" );
		Transport.send(message);
	}catch(MessagingException ex) { 
		throw new RuntimeException(ex);
	}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Offre getOffre() {
		return offre;
	}


	public void setOffre(Offre offre) {
		this.offre = offre;
	}





	public Client getClient() {
		return client;
	}





	public void setClient(Client client) {
		this.client = client;
	}


	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
}

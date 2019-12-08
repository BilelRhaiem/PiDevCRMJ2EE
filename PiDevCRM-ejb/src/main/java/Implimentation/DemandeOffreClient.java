package Implimentation;

import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Interfaces.DemandeOffreClientRemote;
import model.OffreClient;
import model.OffreClientPK;


@Stateless
@LocalBean
public class DemandeOffreClient implements DemandeOffreClientRemote{


	private static final String SMTP_SERVER = "smtp.gmail.com";
	private static final String USERNAME = "mohamedamine.elhaddad@esprit.tn";
	private static final String PASSWORD = "183JMT0057";
	static final int PORT = 587;
	
	@PersistenceContext(unitName="primary")
	EntityManager em;
	

	
	
	public void sendMail(String recipient, String content, String subject) {

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", SMTP_SERVER);
		props.put("mail.smtp.user", USERNAME);
		props.put("mail.smtp.password", PASSWORD);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = {recipient};

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		try {

			message.setFrom(new InternetAddress(USERNAME));

			InternetAddress[] toAddress = new InternetAddress[to.length];

			for (int i = 0; i < to.length; i++)
				toAddress[i] = new InternetAddress(to[i]);

			for (int i = 0; i < toAddress.length; i++)

				message.addRecipient(Message.RecipientType.TO, toAddress[i]);

			message.setSubject(subject);
			message.setText("here i put the details of the offre");
			Transport transport;
			transport = session.getTransport("smtp");
			transport.connect(SMTP_SERVER, USERNAME, PASSWORD);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (NoSuchProviderException e2) {
			// TODO Auto-generated catch block
			System.out.println(e2.getMessage());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	

	
	
	
	@Override
	public void ajouterDemande(int OffreId, int ClientId) {
		
		
		
		OffreClientPK offcPK = new OffreClientPK();
		offcPK.setClient_IdClient(ClientId);
		offcPK.setOffre_IdOffre(OffreId);
		
		OffreClient offc = new OffreClient();
		offc.setId(offcPK);
		
		em.persist(offc);
		
	}




	@Override
	public boolean checkifDemanded(int IdOffre, int IdClient) {
		TypedQuery<OffreClient> q = em.createQuery("select e from OffreClient e where e.id.offre_IdOffre = :IdOffre and e.id.client_IdClient = :IdClient",OffreClient.class);
		 q.setParameter("IdOffre", IdOffre);
		 q.setParameter("IdClient", IdClient);
		
		return !q.getResultList().isEmpty();
	}






	@Override
	public void DeleteDemande(int IdOffre, int Idclient) {
		Query q  = em.createQuery("select p from OffreClient p where p.id.offre_IdOffre=:IdOffre and p.id.client_IdClient =:Idclient");
		q.setParameter("IdOffre", IdOffre);
		q.setParameter("Idclient", Idclient);
		OffreClient oc = (OffreClient) q.getSingleResult();
		em.remove(em.find(OffreClient.class, oc.getId()));
	}

}

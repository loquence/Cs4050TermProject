package boundary;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import java.util.logging.Level;
import java.util.logging.Logger;
@Stateless
public class Mailer {
	
	//@Resource(lookup="java:jboss/mail/gmail")
	private Session session;
	
	public int send(String to, String subject, String msg) throws NamingException {
		
		
		
		try {
			InitialContext ic = new InitialContext();
			session = (Session) ic.lookup("java:jboss/mail/gmail");
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(msg,"text/html");
 
            Transport.send(message);
 
        } catch (MessagingException e) {
            Logger.getLogger(Mailer.class.getName()).log(Level.WARNING, "Cannot send mail", e);
            return -1;
        }
		return 0;
		
	}
	

}

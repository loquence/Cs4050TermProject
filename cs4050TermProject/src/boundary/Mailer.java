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
	
	//Server session object
	private Session session;
	
	/**
	 * tries to send mail to the 'to' email
	 * @param to
	 * @param subject
	 * @param msg
	 * @return
	 * @throws NamingException
	 */
	public int send(String to, String subject, String msg) throws NamingException {	
		try {
			InitialContext ic = new InitialContext();//InitialContext object
			session = (Session) ic.lookup("java:jboss/mail/gmail");//lookup on java:jboss/mail/gmail jndi on the server standalone.xml
            Message message = new MimeMessage(session);//creates message
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));//set the recipients
            message.setSubject(subject);//sets the subject
            message.setContent(msg,"text/html");//sets the content
 
            Transport.send(message);//sends message
 
        } catch (MessagingException e) {
            Logger.getLogger(Mailer.class.getName()).log(Level.WARNING, "Cannot send mail", e);//logs error
            return -1;//returns -1 on failure
        }
		return 0;//returns 0 on success
		
	}
	

}

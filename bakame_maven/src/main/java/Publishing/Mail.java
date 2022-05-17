package Publishing;
import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public static void sendMail(String recipient, String textSent) throws MessagingException {
		// TODO Auto-generated method stub
		
		// Java program to send email

		System.out.println("About to Send mail");
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			
			String myAccountEmail = "ndashimax37@gmail.com";
			String password = "mamamaxbr";
			
			Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(myAccountEmail,password);
			
			}
			});
			
			
			Message message = prepareMessage(session, myAccountEmail, recipient, textSent);
	
			Transport.send(message);
			System.out.println("Message sent successfully!!!");
	}

	private static Message prepareMessage(Session session, String myAccountEmail, String recipient, String textSent) {
		Message message  = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("Evaluation des points obtenus en classe");
			message.setText(textSent);
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		


	}



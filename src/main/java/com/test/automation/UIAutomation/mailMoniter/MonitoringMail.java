package com.test.automation.UIAutomation.mailMoniter;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.test.automation.UIAutomation.customListener.Listener;

public class MonitoringMail
{
	//http://www.codejava.net/java-ee/javamail/send-e-mail-with-attachment-in-java
	public static Logger log = Logger.getLogger(MonitoringMail.class.getName());
	public static void sendmail
	(		String host,
			String port,			
			String from,
			final String password,
			String to,
			String cc,
			final String username,
			String subject,
			String messagebody,
			String attachmentpath,
			String attachmentname
			)

	
	{	
		  // sets SMTP server properties
	    /*  Properties props = new Properties();
	      props.put("mail.smtp.auth", "false");
	      props.put("mail.smtp.starttls.enable", "false");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", port);*/

		Properties props = System.getProperties();
	      //Properties props = new Properties();
	      props.setProperty("mail.smtp.host", host);
	      props.setProperty("mail.smtp.port", port);
	     // props.setProperty("mail.smtp.auth", "false");//default is true
	     // props.setProperty("mail.smtp.starttls.enable", "true");
	      props.setProperty("mail.user", username);
	      props.setProperty("mail.password", password);
	      
	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
	         });
	      //Session session = Session.getDefaultInstance(props);
	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         
	         //set To field of the to
	        // String to2 = "yogeshsolanki@rangam.com , shahinrana@rangam.com, hirendrarajawat@rangam.com";
	         InternetAddress[] parse = InternetAddress.parse(to , true);
	         message.setRecipients(javax.mail.Message.RecipientType.TO,  parse);
	         //message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

	         //set To field of the cc	
	         InternetAddress[] parse2 = InternetAddress.parse(cc , true);
	         message.setRecipients(javax.mail.Message.RecipientType.TO,  parse2);
	         //message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
	         
	         // Set Subject: header field
	         message.setSubject(subject);

	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText(messagebody);

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	        
	         DataSource source = new FileDataSource(attachmentpath);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(attachmentname);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         Transport.send(message);

	         System.out.println("Send Mail successfully....");
	  
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
		
	}

}

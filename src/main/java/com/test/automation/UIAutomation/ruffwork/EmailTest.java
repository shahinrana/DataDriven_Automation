package com.test.automation.UIAutomation.ruffwork;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.annotations.Test;

public class EmailTest {

	@Test
	public static void testMailSending() {    
	      // Recipient's email ID needs to be mentioned.
	      String to = "hirendrarajawat@rangam.com";
	      //String cc = "hirendrarajawat@rangam.com";

	      // Sender's email ID needs to be mentioned
	      String from = "yogeshsolanki@rangam.com";

	      // Assuming you are sending email from localhost
	      String host = "mail.rangamgroup.com";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try {
	    	  System.out.println("Sending Test Mail...");
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         
	       //set To field of the cc to send to multiple recipients....
	         message.setRecipients(Message.RecipientType.CC, "hirendrarajawat@rangam.com,shahinrana@rangam.com");

	         // Set Subject: header field
	         message.setSubject("Selenium test mail");

	         // Now set the actual message
	         message.setText("This is the test email from Selenium (Only Text File)");

	         // Send message
	         Transport.send(message);
	         System.out.println("Email Sent successfully to the user....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}

}

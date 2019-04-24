package com.test.automation.UIAutomation.ruffwork;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
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

public class EmailAttachmentSender {

	public static void sendEmailWithAttachments(String host, String port, final String userName, final String password,
			String toAddress, String subject, String message, String[] attachFiles)
			throws AddressException, MessagingException {
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "false");// default is true
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", userName);
		properties.put("mail.password", password);

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
		if (attachFiles != null && attachFiles.length > 0) {
			for (String filePath : attachFiles) {
				MimeBodyPart attachPart = new MimeBodyPart();

				try {
					attachPart.attachFile(filePath);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				multipart.addBodyPart(attachPart);
			}
		}

		// sets the multi-part as e-mail's content
		msg.setContent(multipart);

		// sends the e-mail
		Transport.send(msg);

	}

	/**
	 * Test sending e-mail with attachments
	 */

	public static void sendEmailWithAttachments2(String host,String port,String userName,String password, String from,
			String to,String cc, String subject, String message, String[] attachFiles) {
		// Recipient's email ID needs to be mentioned.
		//String to = toAddress;
		// String cc = "hirendrarajawat@rangam.com";

		// Sender's email ID needs to be mentioned
		//String from = "yogeshsolanki@rangam.com";

		// Assuming you are sending email from localhost
		//String host = "mail.rangam.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", port);
		properties.setProperty("mail.user", userName);
        properties.setProperty("mail.password", password);
		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			System.out.println("Sending Test Mail...");
			// Create a default MimeMessage object.
			MimeMessage msg = new MimeMessage(session);

			// Set From: header field of the header.
			msg.setFrom(new InternetAddress(from));

			 //set To field of the to
	         InternetAddress[] parse = InternetAddress.parse(to , true);
	         msg.setRecipients(javax.mail.Message.RecipientType.TO,  parse);
	         //message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

	         //set To field of the cc	
	         InternetAddress[] parse2 = InternetAddress.parse(cc , true);
	         msg.setRecipients(javax.mail.Message.RecipientType.CC,  parse2);

			// Set Subject: header field
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			// Now set the actual message
			//msg.setText("This is the test email from Selenium (Only Text File)");

			
			  // creates message part
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setContent(message, "text/html");			
			
			 // creates multi-part
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	 
	        // adds attachments
	        if (attachFiles != null && attachFiles.length > 0) {
	            for (String filePath : attachFiles) {
	                MimeBodyPart attachPart = new MimeBodyPart();
	 
	                try {
	                    attachPart.attachFile(filePath);
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	 
	                multipart.addBodyPart(attachPart);
	            }
	        }
	 
	        // sets the multi-part as e-mail's content
	        msg.setContent(multipart);
			
			
			
			
			
			// Send message
			Transport.send(msg);
			System.out.println("Email Sent successfully to the user....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// SMTP info
		String host = "mail.rangamgroup.com";
		String port = "25";
		String mailFrom = "yogeshsolanki@rangam.com";
		String password = "may@2018";

		// message info
		String mailTo = "yogeshsolanki@rangam.com";
		String mailCC = "shahinrana@rangam.com";
		String subject = "New email with attachments";
		String message = "I have some attachments for you.";

		// attachments
		String[] attachFiles = new String[1];
		attachFiles[0] = "Z:\\Java_Project\\Workspace\\UIAutomation-master\\UIAutomation-master\\automation.log";
		String attach= "Z:\\Java_Project\\Workspace\\UIAutomation-master\\UIAutomation-master\\automation.log";
	/*	attachFiles[1] = "Z:\\Java_Project\\Workspace\\UIAutomation-master\\UIAutomation-master\\test-output\\emailable-report.html";
		attachFiles[2] = "Z:\\Java_Project\\Workspace\\UIAutomation-master\\UIAutomation-master\\extentconfig\\AutomationReport.html";*/

		try {
			sendEmailWithAttachments2(host,port,mailFrom,password,mailFrom, mailTo, mailCC,subject, message,attachFiles);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}

}

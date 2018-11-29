package com.torenzo.qa.util;

import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class TestMail {

	public static void main(String[] args) {
	
		try {
			sendPlainTextEmail();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
		
		
	public static void sendPlainTextEmail() throws AddressException,
            MessagingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.googlemail.com");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
// *** BEGIN CHANGE
        properties.put("mail.smtp.user","patilkrishna668@gmail.com");

        // creates a new session, no Authenticator (will connect() later)
        Session session = Session.getDefaultInstance(properties);
// *** END CHANGE

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress("patilkrishna668@gmail.com"));
        InternetAddress[] toAddresses = { new InternetAddress("sachin.patil.uk@gmail.com") };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject("Hello");
        msg.setSentDate(new Date());
        // set plain text message
        msg.setText("How are yuu?");
        
        

// *** BEGIN CHANGE
        // sends the e-mail
        Transport t = session.getTransport("smtp");
        t.connect("patilkrishna668@gmail.com", "");
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
// *** END CHANGE

    }
		

	}



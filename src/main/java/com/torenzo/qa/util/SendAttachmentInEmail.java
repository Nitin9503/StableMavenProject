package com.torenzo.qa.util;

import io.appium.java_client.AppiumDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

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

import org.openqa.selenium.logging.LogEntry;
import static com.torenzo.qa.util.StaticVariable.OSname;
import static com.torenzo.qa.util.StaticVariable.screenshotName1;
import static com.torenzo.qa.util.StaticVariable.image;




import io.appium.java_client.android.AndroidDriver;
public class SendAttachmentInEmail {
	public static void main(String[] args) throws InterruptedException {
		SendAttachmentInEmail ml = new SendAttachmentInEmail();
		ml.email();
		}
	public void email() throws InterruptedException
		{    String filename2;
		     String filename;		
             String image;
             DataSource fds;
             String to = "arjunthawkar84@gmail.com";
		     //String to = "sachin.patil.uk@gmail.com";
	         String from = "patilkrishna668@gmail.com";
	         final String username = "patilkrishna668@gmail.com";//change accordingly
		     final String password = "9552619077";//change accordingly	
		     String host = "smtp.googlemail.com";
	         String host1 = "localhost";
	         
	         Properties props = new Properties();
		    props.put("mail.smtp.auth", "true");
		    props.put("pro.turbo-smtp.com", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.port", 587);
		    props.put("-Djava.net.preferIPv4Stack", "true");
		    props.setProperty("mail.smtp.host", host);

	    Session session = Session.getDefaultInstance(props,
	  		  
	  		         new javax.mail.Authenticator() {
	  		           protected javax.mail.PasswordAuthentication getPasswordAuthentication()  {
	  		
	  		           return new javax.mail.PasswordAuthentication( username, password.toString());
	  	
	  		          }
	  		  
	  		          });
		
	    try {
	     System.out.println("Attach capture screenshot and here is screenshot name ==>"+screenshotName1);
           Message message = new MimeMessage(session);
	       message.setFrom(new InternetAddress(from));
	       message.setRecipients(Message.RecipientType.TO,
	          InternetAddress.parse(to));
	       message.setSubject("Testing Report");
	       //
	       BodyPart messageBodyPart = new MimeBodyPart();
	       messageBodyPart.setText("It's execution reprot of the test cases and it's conatin log , screenshot and .html file");
	
	       MimeMultipart multipart1 = new MimeMultipart("related");

	         // first part (the html)
	         BodyPart messageBodyPart1 = new MimeBodyPart();
	         if(OSname.equalsIgnoreCase("Mac OS X")){
	       
	          image = "/Users/rahul.kardel/Documents/ArjunT/AppiumWork/AppiumMavenProject/Screenshot/"+ screenshotName1 +".jpeg";
	          messageBodyPart1.setContent(image, "text/html");
	         }
	         
	         else if(OSname.equalsIgnoreCase("Windows 7")){
	          image = "E:\\Appium1\\AppiumMavenProject\\Screenshot\\"+ screenshotName1 +".jpeg";
	          messageBodyPart1.setContent(image, "text/html");
	        }
	         
	         multipart1.addBodyPart(messageBodyPart1);
	         messageBodyPart1 = new MimeBodyPart();
	         if(OSname.equalsIgnoreCase("Mac OS X")){
	    	  fds = new FileDataSource("/Users/rahul.kardel/Documents/ArjunT/AppiumWork/AppiumMavenProject/Screenshot/"+ screenshotName1 +".jpeg");  
	    	   messageBodyPart1.setDataHandler(new DataHandler(fds));
	    		      }
	         else if(OSname.equalsIgnoreCase("Windows 7")){
	    	  fds = new FileDataSource("E:\\Appium1\\AppiumMavenProject\\Screenshot\\"+ screenshotName1 +".jpeg");
	    	   messageBodyPart1.setDataHandler(new DataHandler(fds));

	      }
	  
	         messageBodyPart1.setHeader("Content-ID", "<image>"); 
	         multipart1.addBodyPart(messageBodyPart1);
	         message.setContent(multipart1);
	         Transport.send(message);
	         System.out.println("Screenshot Sent successfully....");
     	
	    } catch (MessagingException e) {
	       throw new RuntimeException(e);
	    }
	         
	        try {
	   	     System.out.println("Attaching .html report from TestNG");
	              Message message = new MimeMessage(session);
	   	       message.setFrom(new InternetAddress(from));
	   	       message.setRecipients(Message.RecipientType.TO,
	   	          InternetAddress.parse(to));
	   	       message.setSubject("Testing Report");
	   	       //
	   	       BodyPart messageBodyPart = new MimeBodyPart();
	   	    messageBodyPart.setText("It's execution reprot of the test cases and it's conatin log , screenshot and .html file");
	         Multipart multipart = new MimeMultipart();
		       multipart.addBodyPart(messageBodyPart);
		       messageBodyPart = new MimeBodyPart();
		       Thread.sleep(5000);		    
		   /*  String filename = "/C:/Users/nikhil.sonawane/Desktop/swap.txt";
		    String filename = "/Users/rahul.kardel/Documents/ArjunT/AppiumWork/AppiumMavenProject/test-output/emailable-report.html";*/
		       
		       if(OSname.equalsIgnoreCase("Mac OS X")){
		    	filename = "/Users/rahul.kardel/Documents/ArjunT/AppiumWork/AppiumMavenProject/test-output/Torenzo.html"; 
		    	   DataSource source = new FileDataSource(filename);
		    	   messageBodyPart.setDataHandler(new DataHandler(source));
		    	     messageBodyPart.setFileName(filename);
		    }
		       else if(OSname.equalsIgnoreCase("Windows 7")){
		    	filename = "E:\\Appium1\\AppiumMavenProject\\test-output\\Torenzo.html"; 
		    	   DataSource source = new FileDataSource(filename);
		    	   messageBodyPart.setDataHandler(new DataHandler(source));
		    	     messageBodyPart.setFileName(filename);
	        }
		     // String filename = "E:/Appium1/Appium/test-output/Default suite/Default test.html";			
		          multipart.addBodyPart(messageBodyPart);
		           messageBodyPart = new MimeBodyPart();
		       // Send the complete message parts
		         message.setContent(multipart);	     
		        Transport.send(message);
                System.out.println(".HTML report Sent successfully....");
 	
	    } catch (MessagingException e) {
	       throw new RuntimeException(e);
	    }
	        
	       try {
		   	           System.out.println("Crash report or Execution report of the app");
		              Message message2= new MimeMessage(session);
		   	          message2.setFrom(new InternetAddress(from));
		   	          message2.setRecipients(Message.RecipientType.TO,
		   	          InternetAddress.parse(to));
		   	           message2.setSubject("Testing Report");
		   	       //
		   	       BodyPart messageBodyPart2 = new MimeBodyPart();
		   	    messageBodyPart2.setText("It's execution reprot of the test cases and it's conatin log , screenshot and .html file");
		         Multipart multipart2 = new MimeMultipart();
			       multipart2.addBodyPart(messageBodyPart2);
			       messageBodyPart2 = new MimeBodyPart();
			    
			    
			     // String filename = "/C:/Users/nikhil.sonawane/Desktop/swap.txt";
			       Thread.sleep(5000);
			      
			       if(OSname.equalsIgnoreCase("Mac OS X")){
			    	   filename2 = "/Users/rahul.kardel/Library/Android/sdk/platform-tools/Sachin.txt";
			  	     DataSource source = new FileDataSource(filename2);
			 	    messageBodyPart2.setDataHandler(new DataHandler(source));
			 	     messageBodyPart2.setFileName(filename2);
			          }
			       
			       else if(OSname.equalsIgnoreCase("Windows 7")){
			    	   filename2 = "C:\\LogFolder\\log5.txt";
			  	     DataSource source = new FileDataSource(filename2);
			 	    messageBodyPart2.setDataHandler(new DataHandler(source));
			 	     messageBodyPart2.setFileName(filename2);
			          }
			     // String filename = "E:/Appium1/Appium/test-output/Default suite/Default test.html";
			       multipart2.addBodyPart(messageBodyPart2);

			      messageBodyPart2 = new MimeBodyPart();
			       // Send the complete message parts
			       message2.setContent(multipart2);
     
			        Transport.send(message2);
	         System.out.println(".txt report Sent successfully....");
	    } catch (MessagingException e) {
		       throw new RuntimeException(e);
		    }
	 }

}



























/*public void log() throws IOException
	{
		

	//	Process process = Runtime.getRuntime().exec("//Users//.....//.....//android-sdk-windows//platform-tools//adb logcat");
		Process process = Runtime.getRuntime().exec("E:");
		    DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
		    Date today = Calendar.getInstance().getTime();
		    String reportDate = df.format(today);
		   // String logPath = "C:\\automation_capture\\";
		    String logPath = "  C:\\LogFolder\\";
		  String testName = "";
		   // log.info(driver.getSessionId() + ": Saving device log...");
		    List<LogEntry> logEntries = driver.manage().logs().get("logcat").filter(Level.ALL);
		    File logFile = new File(logPath + reportDate + "_" + testName + ".txt");
		    PrintWriter log_file_writer = new PrintWriter(logFile);
		    log_file_writer.println(logEntries);
		    log_file_writer.flush();
		//    log.info(driver.getSessionId() + ": Saving device log - Done.");
		System.out.println(": Saving device log - Done.");
		    }*/
	

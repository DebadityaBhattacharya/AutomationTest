package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
public class EmailUtil {
	
	
	//********************* Email with attachment *********************
	public static Properties CONFIG;
	public static  int Passedcase;
	private static int failedItems;
	private static int skipitems;
	
	public static void sendAttachmentEmail(Session session, String toEmail, String subject, String body) throws Exception {
	     try{
	          MimeMessage msg = new MimeMessage(session);      
	          msg.setFrom(new InternetAddress("debaditya.bhattacharya@abpdigital.in", "NoReply-ABP"));
	          msg.setReplyTo(InternetAddress.parse("debaditya.bhattacharya@abpdigital.in", false));
	         
	          msg.setSubject(subject, "UTF-8");
	          msg.setSentDate(new Date());
	          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	          
	        
	          // Create the message body part
	          BodyPart messageBodyPart = new MimeBodyPart();
	          
	          // creates body part for the attachment
	          MimeBodyPart attachPart = new MimeBodyPart();
	       
	          
	          
	          //Calling function to attach the HTML report in a Email Body
	          
	           body=readFile(System.getProperty("user.dir")+"\\test-output\\emailable-report.html");
	          
	          // Fill the bodypart in Email body
	          messageBodyPart.setContent(body,"text/html");
	          msg.setContent(body,"text/html");
	          
	          
	          // Create a multipart message for attachment
	          Multipart multipart = new MimeMultipart();
	  
	          
	     
	          
	          String directory = CONFIG.getProperty("scrfolder");//   "D:\\Candidate\\screenshots";
	          System.out.println("screenshot directory is..."+directory);
			  File[] files = new File(directory).listFiles();
	          String[] attachFiles = new String[files.length + 1];
	          int i =0;
	        
	          for(File file : files){
	        	  
	            if(file.isFile() && i<files.length +1){
	             // System.out.println(file.getAbsolutePath());
	              attachFiles[i] = file.getAbsolutePath();
	             // System.out.println(i);
	              
	            }
	            i++;
	          }
	        
	          attachFiles[files.length] = System.getProperty("user.dir")+"\\config\\Application.log";
	          if (attachFiles != null && attachFiles.length > 0) {
		            for (String filePath : attachFiles) {
					File f = new File(filePath);
		                 attachPart = new MimeBodyPart();
		 
		                try {
		                    if(f.exists() && !f.isDirectory()){
		                    attachPart.attachFile(filePath);
		                	} else {
		                		//System.out.println(filePath);
		                		continue;
		                		
		                	}
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		 
		                multipart.addBodyPart(attachPart);
		            }
		        }
	          
	        
        
	          multipart.addBodyPart(messageBodyPart);
	          // Send the complete message parts
	          msg.setContent(multipart);
	          msg.saveChanges();
	          
	          // Send message
	          Transport.send(msg);
	          System.out.println("Email Sent Successfully!!");
	       }catch (MessagingException e) {
	          e.printStackTrace();
	       } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	     }
	 }
		
	private static String readFile( String file ) throws Exception {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}
	
	
	
	public static void main(String[] args) throws Exception {
        CONFIG =new Properties();
		 FileInputStream cn=new FileInputStream(System.getProperty("user.dir")+"\\config\\Config.properties");
		 CONFIG.load(cn);
		
        final String fromEmail = "debaditya.bhattacharya@abpdigital.in"; //requires valid email id
        final String password = "Menaka*111"; // correct password for email id
        
         String[] text = new String[4];
        try {

        	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        	Document doc = docBuilder.parse (new File(System.getProperty("user.dir")+"/test-output/testng-results.xml"));

        	// normalize text representation
        	doc.getDocumentElement ().normalize ();
        	
        	NodeList results = doc.getElementsByTagName("testng-results");
        	
        	Element firstNameElement = (Element)results.item(0);
        	NamedNodeMap r2 = firstNameElement.getAttributes();
        	
        	System.out.println(r2.getLength());
        	
        	// get the pass, fail and skip counts of test case execution
			Passedcase = Integer.parseInt(r2.item(1).getNodeValue());
			failedItems = Integer.parseInt(r2.item(0).getNodeValue());
        	skipitems = Integer.parseInt(r2.item(2).getNodeValue());
        	 

        	
        	for (int i = 0; i < r2.getLength(); ++i)
        	{
        	    Node attr = r2.item(i);
        	    text[i]=attr.getNodeName() + " = \"" + attr.getNodeValue() + "\"";
//        	    System.out.println("value of text variable is "+(i)+text[i]);
        	    //System.out.println(attr.getNodeName() + " = \"" + attr.getNodeValue() + "\"");
        	}

        } catch(Exception e){
        	
        }
        
       
        System.out.println("value of passed test cases is..... "+ Passedcase);
        final String toEmail;
        
      //  if (failedItems > 20) {
        	 toEmail = "jaspreet.oberoi@abpdigital.in,rohit.negi@abpdigital.in,debaditya.bhattacharya@abpdigital.in,nupur.tyagi@abpdigital.in,pallav.jagoori@abpdigital.in";
      //  } else {
        //		toEmail = "debaditya.bhattacharya@abpdigital.in,rohit.negi@abpdigital.in";   	
       // 		}
        
        
         // any email id
         
        
        
        
        Properties props = new Properties();
        
      /* // props.put("mail.smtp.host", "pod51024.outlook.com"); //SMTP Host - office 
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host - office
      //  props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
*/      
        
        //===============================
        props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
        //===============================
        
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
        //override the getPasswordAuthentication method
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(fromEmail, password);
        	}
        };
	
	    Session session = Session.getInstance(props, auth);
	//	System.out.println(CONFIG.getProperty("testSiteURL"));
	    System.out.println("Authorization passed...");
	    
	     //Calling Email Function with attachment
       // EmailUtil.sendAttachmentEmail(session, toEmail," TR: "+ "Total number of articles in ABP are - " + test_sitemap.base.flag +"Total number of articles in Ebela are " + test_sitemap.base.flag +" "+ Arrays.toString(text), "Sir, Check your Automation report with attached logs.");
	    EmailUtil.sendAttachmentEmail(session, toEmail," TR: "+ "CMS TestHourly" +" "+ Arrays.toString(text), "Sir, Check your Automation report with attached logs.");
		
		        try{
        	ExplicitlyFail_JenkinJob();
        }
        catch(Exception e)
        {
        	 e.printStackTrace();
        }
	}     
	
	private static void ExplicitlyFail_JenkinJob() {
		// TODO Auto-generated method stub
		try{
			if(failedItems>0 || skipitems>0)
            {
            	System.out.println("No of Failed and skiped Items");
//           	throw new Exception();
            	System.exit(1);
            }
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	} 	
}	            
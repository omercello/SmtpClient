package com.inovasyon.smtp;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SmtpClient {

	public static String mail= "mailadresi";
	public static String password = "password";
	public static String toMail= "mailadresi";

	public static void main(String args[]) throws MessagingException {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.live.com");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return Credentials.getPasswordAuthentication();
			}
		});

		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(mail));
		msg.setSubject("Auto Generated Mail - CELLO23");
		msg.setText("Testing Mail");
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.live.com", 587, mail, password);
		transport.sendMessage(msg, msg.getAllRecipients());
		System.out.println("Mail sent successfully at ");
		transport.close();
	}

}



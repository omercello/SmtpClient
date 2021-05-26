package com.inovasyon.smtp;

import javax.mail.PasswordAuthentication;

public final class Credentials {

	public static PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("omer.cel", SmtpClient.password);
	}

}

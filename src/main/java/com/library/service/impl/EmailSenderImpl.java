package com.library.service.impl;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderImpl  {
private MailSender mail;


public void setMailSender(MailSender mail){
	this.mail=mail;
}

	public void sendMail(String from,String to, String subject, String body) {
		   SimpleMailMessage message = new SimpleMailMessage();
		   message.setFrom(from);
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(body);
	        mail.send(message);
		
	}

}

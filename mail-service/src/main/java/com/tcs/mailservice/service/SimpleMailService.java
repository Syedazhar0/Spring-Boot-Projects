package com.tcs.mailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.tcs.mailservice.details.MailDetails;

@Service
public class SimpleMailService {
	
	@Value("${app.sender.mail}")
	private String senderMail;
	
	
	@Autowired 
	private JavaMailSender javaMailSender;
	
	
	public String sendMail(  MailDetails mailDetails) {
		try {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(senderMail);
		message.setTo(mailDetails.getReceiverMail());
		message.setText(mailDetails.getBody());
		message.setSubject(mailDetails.getSubject());
		
	   javaMailSender.send(message);
		
		return "email sent successfully........" ;
		}catch (Exception e) {
			return "email sent failed.....";
		}
	}

}
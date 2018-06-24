package com.travel.Agent.services;

import org.springframework.stereotype.Service;

import com.travel.Agent.dto.MessageDto;
import com.travel.Agent.model.RegUser;
import com.travel.Agent.soap.MessageSoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

@Service
public class EmailService {
	
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	public void sendEmailToRegUser(RegUser reguser) throws MailException, InterruptedException {
		
		System.out.println("alooo");
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(reguser.getEmail());
		System.out.println(reguser.getEmail());
		email.setFrom(env.getProperty("spring.mail.username"));
		System.out.println(env.getProperty("spring.mail.username"));
		email.setSubject("Poruka od vlasnika smestaja");
		String text = "Postovani, uspesno ste rezervisali vasu smestajnu jedinicu !";
		email.setText(text);
		System.out.println("mmmmm");
		javaMailSender.send(email);
		
		
	}
	
	
	
	public void sendMessage(MessageDto mess) {
		
		
		MessageSoap messagesoap = new MessageSoap();
		messagesoap.sendMessageSoap("sendMail",mess);
	}

}

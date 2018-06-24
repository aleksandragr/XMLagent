package com.travel.Agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.Agent.model.RegUser;
import com.travel.Agent.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/email")
public class EmailSendController {
	
	private Logger logger = LoggerFactory.getLogger(EmailSendController.class);
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<RegUser> sendEmail (@RequestBody RegUser reguser) {
		System.out.println("eeee");
		try {
			emailService.sendEmailToRegUser(reguser);
			return new ResponseEntity<>(reguser,HttpStatus.OK);
		}catch(Exception e) {
			logger.info("Greska prilikom slanja emaila" + e.getMessage());
		}
		return null;	
		
	}

}

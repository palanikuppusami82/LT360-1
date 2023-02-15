package com.ladera.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.service.EmailService;

@RequestMapping("ladera/email/")
@RestController
public class EmailController {

	Logger logger = LoggerFactory.getLogger(EmailController.class);

	@Autowired
	EmailService emailService;
	
	@PostMapping("sendEmail")
	public String sendEmail(@RequestParam("emailCode") final String emailCode,@RequestParam("emailId")String emailId) {
		logger.info("Room create request :: {} , {}",emailCode,emailId);
		emailService.sendEmail(emailCode, emailId);
		return "Success";
	}
}

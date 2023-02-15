package com.ladera.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ladera.controller.RoomController;
import com.ladera.model.Email;
import com.ladera.repository.EmailRepository;
import com.ladera.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired     
	 private JavaMailSender javaMailSender;
	
	@Autowired
	private EmailRepository emailRepository;
	
	
	@Override
	public boolean sendEmail(String emailCode,String toEmail) {
		Email email = emailRepository.getEmailByCode(emailCode);
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			helper.setSubject(email.getEmailSubject());
			helper.setTo(InternetAddress.parse(toEmail, false));
			byte[] bytes = email.getEmailBody().getBytes(1, (int) email.getEmailBody().length());//Convert into Byte array
			String blobString = new String(bytes);//Convert Byte Array into String
			helper.setText(blobString, true);
			helper.setFrom("support@ladera.com"); // Added for Mail service 554 exception
			msg.setReplyTo(InternetAddress.parse("support@ladera.com", false));
			msg.setSentDate(new Date());
			Transport.send(msg);
			javaMailSender.send(msg);
			return true;
		}catch(Exception e) {
			logger.error("unable to send email {}, {} due to {}",emailCode,toEmail,e.getMessage());
		}
		return false;
	}

}

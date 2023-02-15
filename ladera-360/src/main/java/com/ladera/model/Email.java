package com.ladera.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "email")
@SequenceGenerator(name = "email_seq", initialValue = 1, allocationSize = 100)
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_seq")
	@Column(name = "id")
	private Long id;

	@Column(name = "email_code")
	private String emailCode;

	public String getEmailCode() {
		return emailCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	@Column(name = "email_subject")
	private String emailSubject;

	@Column(name = "email_body")
	private Blob emailBody;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public Blob getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(Blob emailBody) {
		this.emailBody = emailBody;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Column(name = "cc")
	private String cc;

	@Column(name = "bcc")
	private String bcc;

	@Column(name = "creation_time")
	private Date creationTime;

	public Email() {
		
	}

	
}

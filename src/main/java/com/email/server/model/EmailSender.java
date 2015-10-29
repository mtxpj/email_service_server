package com.email.server.model;

import java.util.Date;

//@Component
public interface EmailSender {

	public void sendEmail(EmailMessage emailMessage);

	// public void sendEmail(String cronExpression, EmailMessage emailMessage);

	public void sendEmail(Date sendingMoment, EmailMessage emailMessage);

	// public void sendEmailFromSMTP(SmtpAccessData smtpAccessData,
	// EmailMessage emailMessage);
}

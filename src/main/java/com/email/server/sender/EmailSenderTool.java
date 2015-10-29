package com.email.server.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.email.server.mail.SmtpEmailSender;
import com.email.server.model.EmailMessage;
import com.email.server.model.EmailSender;

@Component
public class EmailSenderTool implements EmailSender {

	@Autowired
	SmtpEmailSender ses;

	public void sendEmail(EmailMessage emailMessage) {
		System.out.println("Sending message with subject: "
				+ emailMessage.getSubject() + "\nto address: "
				+ emailMessage.getAddresseeList().toString());
		ses.sendEmail(emailMessage);
	}

	public void sendEmail(Date sendingMoment, EmailMessage emailMessage) {
		// TODO Auto-generated method stub

	}

}

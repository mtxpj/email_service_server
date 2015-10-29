package com.email.server.mail;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.email.server.model.EmailMessage;
import com.email.server.model.EmailSender;
import com.email.server.tools.StringAndListTools;

@Component
public class SmtpEmailSender implements EmailSender {

	@Autowired
	private JavaMailSender jms;

	public void sendEmail(EmailMessage em) {
		System.out.println(SmtpEmailSender.class.toString() + " im in.");
		MimeMessage actualMessage = jms.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(actualMessage, true);

			helper.setSubject(em.getSubject());
			// helper.setTo(addresseeArray);
			helper.setTo(new StringAndListTools()
					.addresseeArrayFromArrayList(em.getAddresseeList()));
			helper.setText(em.getMessage());
			helper.setReplyTo(em.getResponseEmail());
			// helper.setFrom(new InternetAddress("****@gmail.com"));

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		jms.send(actualMessage);
	}

	public void sendEmail(Date sendingMoment, EmailMessage emailMessage) {
		// TODO Auto-generated method stub

	}

}

package com.email.server.sender;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.email.server.model.EmailMessage;

//@Component
public class SendEmailsUpToTime {

	@Autowired
	SendAndDeleteSingleEmail sade;

	public void sendEmailsOnlyToGivenSendingMoment(
			ArrayList<EmailMessage> emList, Date sendingMoment) {
		for (EmailMessage em : emList) {
			if (em.getSendingDate().getTime() < sendingMoment.getTime()) {
				sade.sendToDate(em, sendingMoment);
			}
		}
	}
}

package com.email.server.sender.scheduler;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.email.server.model.EmailMessage;
import com.email.server.sender.SendAndDeleteEmailsList;

@Component
public class CronTasks {

	@Autowired
	PickEmailsToSend pets;

	@Autowired
	SendAndDeleteEmailsList sadel;

	public void pickAndSendAllEmails() {
		ArrayList<EmailMessage> emailMessagesAL = pets.getAllEmailsToSend();
		sadel.sendEmails(emailMessagesAL);
	}

	// public void pickAndSendAllEmailsExceptFutureOnes() {
	// ArrayList<EmailMessage> emailMessagesAL = pets
	// .getAllEmailsExceptThoseScheduledToBeSentLater();
	// sadel.sendEmails(emailMessagesAL);
	// }
}

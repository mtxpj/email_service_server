package com.email.server.sender.scheduler;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.email.server.model.EmailMessage;
import com.email.server.save.entities.Email;
import com.email.server.save.saverTools.ReadWriteDbMethods;
import com.email.server.tools.Entity2PojoAdapter;

@Component
public class PickEmailsToSend {

	@Autowired
	ReadWriteDbMethods rwdm;

	@Transactional
	public ArrayList<EmailMessage> getAllEmailsToSend() {
		ArrayList<Email> emailAL = rwdm.getAllEmails();
		ArrayList<EmailMessage> emailMessageAL = new ArrayList<>();
		for (Email email : emailAL) {
			emailMessageAL.add(new Entity2PojoAdapter()
					.convertEmailEntityToEmailMessage(email));
		}
		return emailMessageAL;
	}

	// public ArrayList<EmailMessage>
	// getAllEmailsExceptThoseScheduledToBeSentLater() {
	// Date currentTime = new Date();
	// return gefd.getAllEmailMessagesBeforeGivenTimeFromDb(currentTime);
	// }

}

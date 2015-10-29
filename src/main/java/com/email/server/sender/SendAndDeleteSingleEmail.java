package com.email.server.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.email.server.model.EmailMessage;
import com.email.server.save.saverTools.ReadWriteDbMethods;
import com.email.server.tools.Entity2PojoAdapter;

@Component
public class SendAndDeleteSingleEmail {

	@Autowired
	EmailSenderTool es;

	@Autowired
	ReadWriteDbMethods rwdm;

	public void sendAndDelete(EmailMessage emailMessage) {
		es.sendEmail(emailMessage);
		// rwdm.deleteEmailById(emailMessage.getId());

	}

	public void sendToDate(EmailMessage emailMessage, Date sendingMoment) {
		es.sendEmail(sendingMoment, emailMessage);
		rwdm.deleteEmail(new Entity2PojoAdapter()
				.convertEmailMessageToEmailEntity(emailMessage));
	}
}

package com.email.server.sender;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.email.server.model.EmailMessage;

@Component
public class SendAndDeleteEmailsList {

	@Autowired
	SendAndDeleteSingleEmail sade;

	public void sendEmails(ArrayList<EmailMessage> emList) {
		for (EmailMessage em : emList) {
			sade.sendAndDelete(em);
		}
	}
}

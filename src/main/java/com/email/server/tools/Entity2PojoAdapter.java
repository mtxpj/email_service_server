package com.email.server.tools;

import java.util.List;

import com.email.server.model.EmailMessage;
import com.email.server.model.EmailMessageBuilder;
import com.email.server.save.entities.AddresseeList;
import com.email.server.save.entities.AttachmentDownloadUrls;
import com.email.server.save.entities.Email;
import com.email.server.save.entities.builders.EmailBuilder;

public class Entity2PojoAdapter {

	public Email convertEmailMessageToEmailEntity(EmailMessage em) {

		List<AttachmentDownloadUrls> attachmentDownloadUrlses = new StringAndListTools()
				.createUrlsListFromEmailMessageStrings(em);

		List<AddresseeList> addresseeLists = new StringAndListTools()
				.createAddresseeListFromEmailMessageStrings(em);

		Email email = new EmailBuilder()
				.withId(em.getId())
				.withSubject(em.getSubject())
				.withMessage(em.getMessage())
				.withResponseEmail(em.getResponseEmail())
				.withResponseName(em.getResponseName())
				.withFailureNotificationUrlFk(
						em.getSendingFailureNotificationURL())
				.withSendingDate(em.getSendingDate())
				.withAttachmentDownloadUrlses(attachmentDownloadUrlses)
				.withAddresseeLists(addresseeLists).build();
		return email;
	}

	public EmailMessage convertEmailEntityToEmailMessage(Email email) {

		List<String> attachmentDownloadUrls = new StringAndListTools()
				.createUrlStringsListFromEmailEntity(email);

		List<String> addresseeLists = new StringAndListTools()
				.createAddresseeStringsListFromEmailEntity(email);
		EmailMessage emailMessage = new EmailMessageBuilder()
				.withId(email.getId())
				.withSubject(email.getSubject())
				.withMessage(email.getMessage())
				.withResponseEmail(email.getResponseEmail())
				.withResponseName(email.getResponseName())
				.withSendingDate(email.getSendingDate())
				.withSendingFailureNotificationURL(
						email.getFailureNotificationUrlFk())
				.withAttachmentDownloadURLs(attachmentDownloadUrls)
				.withAddresseeList(addresseeLists).build();
		return emailMessage;
	}
}

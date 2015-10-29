package com.email.server.save.saverTools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.email.server.save.entities.AddresseeList;
import com.email.server.save.entities.AttachmentDownloadUrls;
import com.email.server.save.entities.Email;
import com.email.server.save.repos.EmailRepository;

@Component
public class ReadWriteDbMethods {

	@Autowired
	EmailRepository er;

	@Transactional
	public void saveEmail(Email email) {
		er.save(email);
	}

	@Transactional
	public void deleteEmail(Email email) {
		er.delete(email);
	}

	@Transactional
	public void deleteEmailById(Long id) {
		er.delete(id);
	}

	@Transactional
	public Email getEmialById(Long id) {
		Email email = er.findOne(id);
		List<AddresseeList> attachments = email.getAddresseeLists();
		for (AddresseeList addresseeList : attachments) {
			addresseeList.getAddressee();
		}
		List<AttachmentDownloadUrls> urls = email.getAttachmentDownloadUrlses();
		for (AttachmentDownloadUrls attachmentDownloadUrls : urls) {
			attachmentDownloadUrls.getId();
		}
		return email;
	}

	@Transactional
	public ArrayList<Email> getAllEmails() {
		ArrayList<Email> emailArrayList = new ArrayList<Email>();
		Iterable<Email> emailsIterableList = er.findAll();
		for (Email email : emailsIterableList) {
			emailArrayList.add(email);
		}
		return emailArrayList;
	}
}

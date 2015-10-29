package com.email.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.server.model.EmailMessage;
import com.email.server.save.entities.Email;
import com.email.server.save.saverTools.ReadWriteDbMethods;
import com.email.server.tools.Entity2PojoAdapter;

@RestController
public class CallController {

	@Autowired
	ReadWriteDbMethods rwdm;

	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public ResponseEntity<EmailMessage> get(@RequestBody EmailMessage em) {
		Email email = new Entity2PojoAdapter().convertEmailMessageToEmailEntity(em);
		rwdm.saveEmail(email);
		return new ResponseEntity<EmailMessage>(em, HttpStatus.OK);
	}

}

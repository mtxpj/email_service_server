package com.email.server.save.saverTools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.email.server.model.EmailMessage;
import com.email.server.save.entities.Email;
import com.email.server.tools.Entity2PojoAdapter;
import com.email.server.tools.GsonMethods;

@Component
public class JsonToDbSaver {

	@Autowired
	ReadWriteDbMethods rwdm;

	@Transactional
	public Long saveJson(String json) {
		EmailMessage em = new GsonMethods().jsonToEmailMessage(json);
		Email email = new Entity2PojoAdapter().convertEmailMessageToEmailEntity(em);
		rwdm.saveEmail(email);
		return email.getId();
	}

}

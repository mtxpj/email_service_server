package com.email.server.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.email.server.Application;
import com.email.server.model.EmailMessage;
import com.email.server.tools.Entity2PojoAdapter;

import exampleData.ExampleDatabaseFilling;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SmtpEmailSenderTest {

	@Autowired
	SmtpEmailSender ses;

	@Test
	public void testSendEmailEmailMessage() {
		EmailMessage em = new Entity2PojoAdapter()
				.convertEmailEntityToEmailMessage(new ExampleDatabaseFilling()
						.getCompleteEmail());
		ses.sendEmail(em);
	}

}

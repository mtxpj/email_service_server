package com.email.server;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.email.server.model.EmailMessage;
import com.email.server.save.entities.Email;
import com.email.server.save.saverTools.JsonToDbSaver;
import com.email.server.save.saverTools.ReadWriteDbMethods;
import com.email.server.tools.Entity2PojoAdapter;
import com.email.server.tools.GsonMethods;

import exampleData.ExampleDatabaseFilling;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EmailMessage2Json2DbTest {

	@Autowired
	JsonToDbSaver tested;

	@Autowired
	ReadWriteDbMethods rwdm;

	@Test
	public void test() {
		// given
		EmailMessage expected = new ExampleDatabaseFilling()
				.getExampleEmailMessage();
		// when
		String json = new GsonMethods().emailMessageToJson(expected);

		Long id = tested.saveJson(json);
		Email email = rwdm.getEmialById(id);
		EmailMessage actual = new Entity2PojoAdapter()
				.convertEmailEntityToEmailMessage(email);

		// than
		Assert.assertEquals(expected.getSubject(), actual.getSubject());
		Assert.assertEquals(expected.getMessage(), actual.getMessage());
		Assert.assertEquals(expected.getResponseName(),
				actual.getResponseName());
		Assert.assertEquals(expected.getResponseEmail(),
				actual.getResponseEmail());
		Assert.assertEquals(expected.getSendingDate().getTime() / 1000, actual
				.getSendingDate().getTime() / 1000);
		Assert.assertEquals(expected.getSendingFailureNotificationURL(),
				actual.getSendingFailureNotificationURL());
		Assert.assertEquals(expected.getAttachmentDownloadURLs().iterator()
				.next(), actual.getAttachmentDownloadURLs().iterator().next());
	}
}

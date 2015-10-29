package com.email.server.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.email.server.model.EmailMessage;

import exampleData.ExampleDatabaseFilling;

public class GsonMethodsTest {

	GsonMethods tested = new GsonMethods();

	@Test
	public void testEmailMessageToJson() {
		// given
		EmailMessage em = new ExampleDatabaseFilling().getExampleEmailMessage();
		String expected = "{\"addresseeList\":[\"addresseeList\",\"gwdrs\",\"sgdfv\",\"kool\"],"
				+ "\"subject\":\"subject\",\"message\":\"message\",\"responseName\":\"responseName\","
				+ "\"responseEmail\":\"responseEmail\",\"sendingDate\":\""
				+ new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(em
						.getSendingDate())
				+ "\",\"attachmentDownloadURLs\":[\"attachmentDownloadURL1\",\"url2\"],"
				+ "\"sendingFailureNotificationURL\":\"sendingFailureNotificationURL\"}";
		// when
		String actual = tested.emailMessageToJson(em);
		// than
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testEmailMessageToString() {
		// given
		EmailMessage em = new ExampleDatabaseFilling().getExampleEmailMessage();
		String expected = "EmailMessage [addresseeList=[addresseeList, gwdrs, sgdfv, kool], subject=subject, "
				+ "message=message, responseName=responseName, responseEmail=responseEmail, sendingDate="
				+ new Date()
				+ ", attachmentDownloadURLs=[attachmentDownloadURL1, url2], sendingFailureNotificationURL=sendingFailureNotificationURL]";
		// when
		String actual = em.toString();
		// than
		Assert.assertEquals(expected, actual);

	}
}

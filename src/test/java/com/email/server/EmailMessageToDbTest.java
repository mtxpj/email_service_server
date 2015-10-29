//package com.email.server;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.email.server.lamaModel.EmailMessage;
//import com.email.server.rest.PostEmailMessageForEntity;
//
//import exampleData.ExampleDatabaseFilling;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//public class EmailMessageToDbTest {
//
//	@Autowired
//	PostEmailMessageForEntity tested;
//
//	@Test
//	public void test() {
//		// given
//		EmailMessage expected = new ExampleDatabaseFilling()
//				.getExampleEmailMessage();
//		String url = new ExampleDatabaseFilling().getABSOLUTE_URI_LOCALHOST()
//				+ "/email";
//		// when
//		EmailMessage actual = tested.post(url, expected);
//		// then
//		Assert.assertEquals(expected.getSubject(), actual.getSubject());
//		Assert.assertEquals(expected.getMessage(), actual.getMessage());
//		Assert.assertEquals(expected.getResponseName(),
//				actual.getResponseName());
//		Assert.assertEquals(expected.getResponseEmail(),
//				actual.getResponseEmail());
//		Assert.assertEquals(expected.getSendingDate().getTime() / 1000, actual
//				.getSendingDate().getTime() / 1000);
//		Assert.assertEquals(expected.getSendingFailureNotificationURL(),
//				actual.getSendingFailureNotificationURL());
//		Assert.assertEquals(expected.getAttachmentDownloadURLs().iterator()
//				.next(), actual.getAttachmentDownloadURLs().iterator().next());
//	}
//}

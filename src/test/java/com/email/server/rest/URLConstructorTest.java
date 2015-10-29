//package com.email.server.rest;
//
//import java.util.Date;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.email.server.Application;
//import com.email.server.lamaModel.EmailMessage;
//import com.email.server.tools.Entity2PojoAdapter;
//
//import exampleData.ExampleDatabaseFilling;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//public class URLConstructorTest {
//
//	@Autowired
//	URLConstructor tested;
//
//	@Test
//	public void testBuildURLFromEmailMessage() {
//		// given
//		EmailMessage em = new Entity2PojoAdapter()
//				.convertEmailEntityToEmailMessage(new ExampleDatabaseFilling()
//						.getCompleteEmail());
//		String expected = "/email/add1/Complete Email Subject/Complete Email Message/"
//				+ "Complete Email Response Name/Complete Email Response Email/"
//				+ new Date()
//				+ "/Complete Email Attachment Download URL/failure.notification.url";
//		// when
//		String actual = tested.buildURLFromEmailMessage(em);
//		// than
//		Assert.assertEquals(expected, actual);
//	}
//
//}

package com.email.server.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.email.server.EmailMessage2Json2DbTest;
import com.email.server.tools.GsonMethodsTest;

import emailSaver.tools.AddEmailToDbTest;

@RunWith(Suite.class)
@SuiteClasses({
		// URLConstructorTest.class,
		GsonMethodsTest.class,
		// EmailMessageToDbTest.class,
		EmailMessage2Json2DbTest.class, AddEmailToDbTest.class })
public class AllTests {

}

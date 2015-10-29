package emailSaver.tools;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.email.server.Application;
import com.email.server.save.entities.Email;
import com.email.server.save.saverTools.ReadWriteDbMethods;

import exampleData.ExampleDatabaseFilling;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class AddEmailToDbTest {

	@Autowired
	ReadWriteDbMethods tested;

	private ExampleDatabaseFilling example = new ExampleDatabaseFilling();

	@Test
	public void testSaveAndGetEmail() {
		// given
		Email expected = example.getCompleteEmail();
		// when
		tested.saveEmail(expected);
		// than
		Email actual = tested.getEmialById(expected.getId());

		Assert.assertEquals(expected.getSubject(), actual.getSubject());
		Assert.assertEquals(expected.getMessage(), actual.getMessage());
		Assert.assertEquals(expected.getResponseEmail(),
				actual.getResponseEmail());
		Assert.assertEquals(expected.getResponseName(),
				actual.getResponseName());

		Assert.assertEquals(expected.getSendingDate().getTime() / 10000, actual
				.getSendingDate().getTime() / 10000);
		Assert.assertEquals(expected.getFailureNotificationUrlFk(),
				actual.getFailureNotificationUrlFk());
		Assert.assertEquals(expected.getAttachmentDownloadUrlses().iterator()
				.next().getUrl(), actual.getAttachmentDownloadUrlses()
				.iterator().next().getUrl());
		Assert.assertEquals(expected.getAddresseeLists().iterator().next()
				.getAddressee(), actual.getAddresseeLists().iterator().next()
				.getAddressee());
	}
}

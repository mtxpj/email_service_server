package exampleData;

import static com.email.server.tools.StringAndListTools.convertStringToList;

import java.util.Date;

import com.email.server.model.EmailMessage;
import com.email.server.model.EmailMessageBuilder;
import com.email.server.save.entities.AddresseeList;
import com.email.server.save.entities.AttachmentDownloadUrls;
import com.email.server.save.entities.Email;
import com.email.server.save.entities.builders.AddresseeListBuilder;
import com.email.server.save.entities.builders.AttachmentDownloadUrlsBuilder;
import com.email.server.save.entities.builders.EmailBuilder;

public class ExampleDatabaseFilling {
	private String ABSOLUTE_URI_LOCALHOST = "http://localhost:8080";

	private String EXAMPLE_URL = "/email/addresseeList,gwdrs,sgdfv,kool/subject/message/"
			+ "responseName/responseEmail/"
			+ new Date()
			+ "/attachmentDownloadURL1,url2/sendingFailureNotificationURL";

	private EmailMessage exampleEmailMessage = new EmailMessageBuilder()
			.withAddresseeList(
					convertStringToList("addresseeList,gwdrs,sgdfv,kool"))
			.withSubject("subject")
			.withMessage("message")
			.withResponseName("responseName")
			.withResponseEmail("responseEmail")
			.withSendingDate(new Date())
			.withAttachmentDownloadURLs(
					convertStringToList("attachmentDownloadURL1,url2"))
			.withSendingFailureNotificationURL("sendingFailureNotificationURL")
			.build();

	private Email completeEmail = new EmailBuilder()
			.withSubject("Complete Email Subject")
			.withMessage("Complete Email Message")
			.withResponseEmail("email@gmail.com")
			.withResponseName("Complete Email Response Name")
			.withSendingDate(new Date())
			.withFailureNotificationUrlFk("failure.notification.url")
			.withAddedAttachmentDownloadUrls(
					new AttachmentDownloadUrlsBuilder().withUrl(
							"Complete Email Attachment Download URL").build())
			.withAddedAddresseeList(
					new AddresseeListBuilder().withAddressee("email@gmail.com").build())
			.build();

	private AddresseeList addresseeList = new AddresseeListBuilder()
			.withAddressee("addressee").withEmail(getEmail()).build();

	private AttachmentDownloadUrls attachmentDownloadUrl = new AttachmentDownloadUrlsBuilder()
			.withUrl("url.to.attachment.download.com/down.pdf").build();

	private Email email = new EmailBuilder()
			.withFailureNotificationUrlFk("failure.notification.url")
			.withAddedAddresseeList(getAddresseeList())
			.withAddedAttachmentDownloadUrls(getAttachmentDownloadUrl())
			.withMessage("message").withSubject("subject")
			.withResponseEmail("response@email.com")
			.withResponseName("response name").build();

	public String getABSOLUTE_URI_LOCALHOST() {
		return ABSOLUTE_URI_LOCALHOST;
	}

	public void setABSOLUTE_URI_LOCALHOST(String aBSOLUTE_URI_LOCALHOST) {
		ABSOLUTE_URI_LOCALHOST = aBSOLUTE_URI_LOCALHOST;
	}

	public String getEXAMPLE_URL() {
		return EXAMPLE_URL;
	}

	public void setEXAMPLE_URL(String eXAMPLE_URL) {
		EXAMPLE_URL = eXAMPLE_URL;
	}

	public EmailMessage getExampleEmailMessage() {
		return exampleEmailMessage;
	}

	public void setExampleEmailMessage(EmailMessage exampleEmailMessage) {
		this.exampleEmailMessage = exampleEmailMessage;
	}

	public AddresseeList getAddresseeList() {
		return addresseeList;
	}

	public void setAddresseeList(AddresseeList addresseeList) {
		this.addresseeList = addresseeList;
	}

	public AttachmentDownloadUrls getAttachmentDownloadUrl() {
		return attachmentDownloadUrl;
	}

	public void setAttachmentDownloadUrl(
			AttachmentDownloadUrls attachmentDownloadUrl) {
		this.attachmentDownloadUrl = attachmentDownloadUrl;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public void setCompleteEmail(Email completeEmail) {
		this.completeEmail = completeEmail;
	}

	public Email getCompleteEmail() {
		return completeEmail;
	}

}

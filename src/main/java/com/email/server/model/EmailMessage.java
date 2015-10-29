package com.email.server.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailMessage {

	private Long id;
	private List<String> addresseeList;
	private String subject;
	private String message;
	private String responseName;
	private String responseEmail;
	private Date sendingDate;
	private List<String> attachmentDownloadURLs;
	private String sendingFailureNotificationURL;

	@Override
	public String toString() {
		return "EmailMessage [addresseeList=" + getAddresseeList()
				+ ", subject=" + getSubject() + ", message=" + getMessage()
				+ ", responseName=" + getResponseName() + ", responseEmail="
				+ getResponseEmail() + ", sendingDate=" + getSendingDate()
				+ ", attachmentDownloadURLs=" + getAttachmentDownloadURLs()
				+ ", sendingFailureNotificationURL="
				+ getSendingFailureNotificationURL() + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getAddresseeList() {
		return addresseeList;
	}

	public void setAddresseeList(List<String> addresseeList) {
		this.addresseeList = addresseeList;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponseName() {
		return responseName;
	}

	public void setResponseName(String responseName) {
		this.responseName = responseName;
	}

	public String getResponseEmail() {
		return responseEmail;
	}

	public void setResponseEmail(String responseEmail) {
		this.responseEmail = responseEmail;
	}

	public Date getSendingDate() {
		return sendingDate;
	}

	public void setSendingDate(Date sendingDate) {
		this.sendingDate = sendingDate;
	}

	public List<String> getAttachmentDownloadURLs() {
		return attachmentDownloadURLs;
	}

	public void setAttachmentDownloadURLs(List<String> attachmentDownloadURLs) {
		this.attachmentDownloadURLs = attachmentDownloadURLs;
	}

	public String getSendingFailureNotificationURL() {
		return sendingFailureNotificationURL;
	}

	public void setSendingFailureNotificationURL(
			String sendingFailureNotificationURL) {
		this.sendingFailureNotificationURL = sendingFailureNotificationURL;
	}
}

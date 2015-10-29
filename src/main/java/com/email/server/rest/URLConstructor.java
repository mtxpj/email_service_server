//package com.email.server.rest;
//
//import static com.email.server.tools.StringAndListTools.convertListToString;
//
//import org.springframework.stereotype.Component;
//
//import com.email.server.lamaModel.EmailMessage;
//
//@Component
//public class URLConstructor {
//
//	public URLConstructor() {
//	}
//
//	public String buildURLFromEmailMessage(EmailMessage em) {
//		StringBuilder url = new StringBuilder();
//		url.append("/email/");
//		url.append(convertListToString(em.getAddresseeList()));
//		url.append("/");
//		url.append(em.getSubject());
//		url.append("/");
//		url.append(em.getMessage());
//		url.append("/");
//		url.append(em.getResponseName());
//		url.append("/");
//		url.append(em.getResponseEmail());
//		url.append("/");
//		url.append(em.getSendingDate());
//		url.append("/");
//		url.append(convertListToString(em.getAttachmentDownloadURLs()));
//		url.append("/");
//		url.append(em.getSendingFailureNotificationURL());
//		return url.toString();
//	}
// }

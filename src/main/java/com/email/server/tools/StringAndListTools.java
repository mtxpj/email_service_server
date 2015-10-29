package com.email.server.tools;

import java.util.ArrayList;
import java.util.List;

import com.email.server.model.EmailMessage;
import com.email.server.save.entities.AddresseeList;
import com.email.server.save.entities.AttachmentDownloadUrls;
import com.email.server.save.entities.Email;

public class StringAndListTools {

	public static List<String> convertStringToList(String inputString) {
		List<String> list = new ArrayList<String>();
		String[] array = inputString.split(",");
		for (String singleString : array) {
			list.add(singleString);
		}
		return list;
	}

	public static String convertListToString(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String string : list) {
			sb.append(string);
			sb.append(",");
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}

	public List<AttachmentDownloadUrls> createUrlsListFromEmailMessageStrings(
			EmailMessage em) {
		List<AttachmentDownloadUrls> attachmentDownloadUrlses = new ArrayList<AttachmentDownloadUrls>();
		for (String string : em.getAttachmentDownloadURLs()) {
			AttachmentDownloadUrls atDU = new AttachmentDownloadUrls(string);
			attachmentDownloadUrlses.add(atDU);
		}
		return attachmentDownloadUrlses;
	}

	public List<AddresseeList> createAddresseeListFromEmailMessageStrings(
			EmailMessage em) {
		List<AddresseeList> addresseeList = new ArrayList<AddresseeList>();
		for (String string : em.getAddresseeList()) {
			AddresseeList aL = new AddresseeList(string);
			addresseeList.add(aL);
		}
		return addresseeList;
	}

	public List<String> createUrlStringsListFromEmailEntity(Email email) {
		List<AttachmentDownloadUrls> adu = email.getAttachmentDownloadUrlses();
		List<String> attachmentDownloadUrls = new ArrayList<String>();
		for (AttachmentDownloadUrls aDU : adu) {
			attachmentDownloadUrls.add(aDU.getUrl());
		}
		return attachmentDownloadUrls;
	}

	public List<String> createAddresseeStringsListFromEmailEntity(Email email) {
		List<String> addressees = new ArrayList<String>();
		for (AddresseeList aL : email.getAddresseeLists()) {
			addressees.add(aL.getAddressee());
		}
		return addressees;
	}

	public String[] addresseArrayFromEmailMessage(EmailMessage em) {
		String[] addresseeArray = new String[em.getAddresseeList().size()];
		em.getAddresseeList().toArray(addresseeArray);
		return addresseeArray;
	}

	public String[] addresseeArrayFromArrayList(List<String> addresseeList) {
		String[] addresseeArray = new String[addresseeList.size()];
		addresseeList.toArray(addresseeArray);
		return addresseeArray;
	}
}

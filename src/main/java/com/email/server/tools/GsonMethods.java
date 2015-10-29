package com.email.server.tools;

import com.email.server.model.EmailMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonMethods {

	public String emailMessageToJson(EmailMessage em) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss")
				.create();
		String json = gson.toJson(em);
		System.out.println(json);
		return json;
	}

	public EmailMessage jsonToEmailMessage(String json) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss")
				.create();
		EmailMessage em = gson.fromJson(json, EmailMessage.class);
		return em;
	}
}

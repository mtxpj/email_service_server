//package com.email.server.rest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import com.email.server.lamaModel.EmailMessage;
//
//@Component
//public class PostEmailMessageForEntity {
//
//	public EmailMessage post(String url, EmailMessage em) {
//		RestTemplate restTemplate = new RestTemplate();
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//		messageConverters.add(new MappingJackson2HttpMessageConverter());
//		restTemplate.setMessageConverters(messageConverters);
//		HttpEntity<EmailMessage> entity = new HttpEntity<EmailMessage>(em);
//
//		ResponseEntity<EmailMessage> response = restTemplate.postForEntity(url,
//				entity, EmailMessage.class);
//		return response.getBody();
//	}
// }

package com.email.server.sender.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	private static final long scheduleInterval = 30 * 1000;

	@Autowired
	CronTasks ct;

	@Scheduled(fixedDelay = scheduleInterval)
	public void sendEmails() {
		System.out.println("Scheduler run");
		ct.pickAndSendAllEmails();
	}
}

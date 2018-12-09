package com.spring.ex2;

public class EmailMessageService implements MessageService {

	public EmailMessageService() {
		System.out.println("Email service is available");
	}
	
	@Override
	public void sendMessage(String to, String msg) {
		System.out.println("Email sent to " + " with message " + msg);
	}

}

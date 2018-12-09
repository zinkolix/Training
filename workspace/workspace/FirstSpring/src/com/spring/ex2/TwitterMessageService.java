package com.spring.ex2;

public class TwitterMessageService implements MessageService {

	public TwitterMessageService() {
		System.out.println("Twitter message sevice is available");
	}
	@Override
	public void sendMessage(String to, String msg) {
		System.out.println("Tweet sent to " + " with message " + msg);
	}

}

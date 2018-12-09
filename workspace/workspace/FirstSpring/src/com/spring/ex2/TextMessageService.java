package com.spring.ex2;

public class TextMessageService implements MessageService {

	public TextMessageService() {
			System.out.println("Text message sevice is available");
	}
	
	@Override
	public void sendMessage(String to, String msg) {
		System.out.println("Text sent to " + " with message " + msg);
	}

}

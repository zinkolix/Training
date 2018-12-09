package ex7;

import org.springframework.stereotype.Component;

@Component("sms")
public class TextMessageService implements MessageService {

	public TextMessageService() {
			System.out.println("Text message sevice is available");
	}
	
	@Override
	public void sendMessage(String to, String msg) {
		System.out.println("Text sent to " + to + " with message " + msg);
	}

}

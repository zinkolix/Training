package ex7;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailMessageService implements MessageService {

	public EmailMessageService() {
		System.out.println("Email service is available");
	}
	
	@Override
	public void sendMessage(String to, String msg) {
		System.out.println("Email sent to " + to + " with message " + msg);
	}

}

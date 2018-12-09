package ex7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
@Repository("provider")
public class MessageProvider {

	@Autowired
	private ApplicationContext appCtx;
	
	public MessageProvider() {

	}
	
	public void serviceProvider(String type, String to, String msg) {
		MessageService service = (MessageService)appCtx.getBean(type);
		service.sendMessage(to, msg);
	}
	

}

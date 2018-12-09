package ex7;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMessageService {

	@Test
	public void messageSender(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("annotatedappctx.xml");
		MessageProvider provider = (MessageProvider)ctx.getBean("provider");
		provider.serviceProvider("email", "zinkixx@gmail.com", "hi");
		provider.serviceProvider("sms", "7406147940", "This is anshu");
		provider.serviceProvider("tweet", "@zinkixx", "I'm the king");
	}
}

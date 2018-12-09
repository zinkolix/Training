package ex8;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ex7.MessageService;

@Named("life")
public class MyLife {
	// Example of CDI injection
	@Inject
	@Qualifier("email")
	MessageService msg;

	@Inject
	private ApplicationContext appCtx;

	public MyLife() {

		System.out.println("MyLife is constructed");
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("Do something when bean destroy");
	}

	@PostConstruct
	public void setup() throws Exception {
		System.out.println("Do something when bean initialized");
		msg.sendMessage("zinkixx", "hello");
	}

}

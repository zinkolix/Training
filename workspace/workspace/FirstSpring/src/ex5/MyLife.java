package ex5;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyLife implements ApplicationContextAware {

	private ApplicationContext appCtx;

	public MyLife() {

		System.out.println("MyLife is constructed");
	}

	public void destroy() {
		System.out.println("Do something when bean destroy");
	}

	public void setup() {
		System.out.println("Do something when bean initialized");
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) throws BeansException {

		System.out.println("Application context is set");
		this.appCtx = appCtx;
	}

}

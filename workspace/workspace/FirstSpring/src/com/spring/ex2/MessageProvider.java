package com.spring.ex2;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MessageProvider implements ApplicationContextAware {

	private ApplicationContext appCtx;
	
	public MessageProvider() {

	}
	
	public void serviceProvider(String type, String to, String msg) {
		MessageService service = (MessageService)appCtx.getBean(type);
		service.sendMessage(to, msg);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext appCtx) throws BeansException {
		this.appCtx = appCtx;
	}

}

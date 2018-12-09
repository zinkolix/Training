package assignment;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CurrencyConverter  implements ApplicationContextAware {
	private ApplicationContext appCtx;

//	private Currency currency;
	public CurrencyConverter() {

	}
	public void convert(String src, String tar, double amount){
		
		Currency source = (Currency)appCtx.getBean(src);
		Currency target = (Currency)appCtx.getBean(tar);
		double price  = target.dollarValue() / source.dollarValue() * amount;
		System.out.println("value " + price);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) throws BeansException {
		this.appCtx = appCtx;
	}
	
}

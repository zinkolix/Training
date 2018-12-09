package assignment;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCurrencyConverter {
//	public static void main(String[] args) {
//		
//		CurrencyConverter cc = new CurrencyConverter();
//		Currency inr = new Rupee();
//		Currency usd = new Dollar();
//		
//		double result = cc.convert(usd, inr, 100);
//		System.out.println("Result:  " + result);
//		
//	}
	
	@Test
	public void testCurrency(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex6/appctx.xml");
		CurrencyConverter converter = (CurrencyConverter)ctx.getBean("mycurrency");
		converter.convert("dollar","rupee",1000);
		
	}

}

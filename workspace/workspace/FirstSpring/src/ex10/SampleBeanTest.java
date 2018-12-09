package ex10;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleBeanTest {

	@Test
	public void testSampleBean() {
		// everytime we need to take care of creating an ApplicationContext
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex10/appctx.xml");

		// then we need to call getBean() to access a particular bean which we
		// need to test
		SampleBean sampleBean = ctx.getBean(SampleBean.class);

		// and finally we get a change to test the bean method
		sampleBean.sampleMethod();
	}

}

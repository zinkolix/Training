package ex10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:ex10/appctx.xml")
public class SampleBeanTest2 {
	
//	Inject the bean which we need to test.
//	why to do it manually. So DI in JUnit also!!
//	@Autowired
//	private SampleBean sampleBean;
	
	@Autowired
	private ApplicationContext appCtx;
	
	@Test
	public void testSampleBean() {
		// Just need to now concentrate on testing the bean
		SampleBean sampleBean = appCtx.getBean(SampleBean.class);
		sampleBean.sampleMethod();
	}

}

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;

public class RuleDemo {

	@Rule
	public TestName name = new TestName();
	
	@Test
	public void printTestMethodName() {
		System.out.println("Test method name: " + name.getMethodName());
		
	}
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void errorCollectorExample() {
		collector.addError(new Throwable("trouble here"));
		collector.addError(new Throwable("trouble there"));
		collector.addError(new Throwable("trouble everywhere"));
	}
}

package ex15;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestProductRepo {

	static {
		System.setProperty("spring.profiles.active", "dev");
	}

	@Test
	public void testErrorHandler() {
		ApplicationContext container = new ClassPathXmlApplicationContext("ex15/appctx.xml");

		ProductRepo repo = container.getBean("prodRepo", ProductRepo.class);
		for (Product p : repo.getAllProducts())
			System.out.println(p);

		// Using Spring EL API
		ExpressionParser parser = new SpelExpressionParser();
		List<Product> products = (List<Product>) parser.parseExpression("allProducts.?[name.startsWith('Nokia')]")
				.getValue(repo);
		System.out.println(products);

		List<String> productNames = (List<String>) parser.parseExpression("allProducts.![name]").getValue(repo);
		
		System.out.println(productNames);
	}
}

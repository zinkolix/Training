import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Product;
import repo.ProductRepo;

public class JpaTest {

	@Test
	public void testJPA() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		ProductRepo productRepo = (ProductRepo) ctx.getBean("jpaProductRepo");

//		 Product p= new Product();
//		 p.setName("Lenovo ThinKpad");
//		 p.setPrice(300000);
//		 productRepo.saveProduct(p);
////		
		 Product p2 = productRepo.getProduct(41);
		 System.out.println(p2.getName());
		//
//		 for (Product product : productRepo.getAll()) {
//		 System.out.println(product.getName());
//		 }
	}
}

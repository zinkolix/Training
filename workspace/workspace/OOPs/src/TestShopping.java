import com.mphasis.product.Product;
import com.mphasis.product.Shopping;

public class TestShopping {

	public static void main(String[] args) {
		Product p1 = new Product(120,"iPhone 7",36000,5);
		Product p2 = new Product(121, "Note 5", 32000,8);
		Product p3 = new Product(211, "ipad pro", 28000,3);
		
		Shopping mycart = new Shopping();
		mycart.addProduct(p1,2);
		mycart.addProduct(p2,3);
		mycart.addProduct(p2, 2);
//		mycart.addProduct(p3, 2);
//		mycart.addProduct(p1, 1);
		//mycart.addProduct(p3, 1);
		//mycart.addProduct(p2,5);
		mycart.summary();
		mycart.payment("1234567891234567", "8/12/2031", 129);
		
//		mycart.addProduct(p3,6);
//		mycart.summary();
	}
}

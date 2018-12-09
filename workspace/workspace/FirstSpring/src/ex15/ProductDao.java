package ex15;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	private List<Product> products;

	public ProductDao() {
		products = new ArrayList<Product>();
		products.add(new Product("Nokia 6600", 4500));
		products.add(new Product("Samsung Galaxy", 9500));
		products.add(new Product("Nokia Lumia", 17500));
		products.add(new Product("Samsung Galaxy s2", 19500));
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}

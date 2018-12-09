package repo;

import java.util.List;

import entity.Product;

public interface ProductRepo {

	void saveProduct(Product p);

	Product getProduct(int id);

	List<Product> getAll();
}

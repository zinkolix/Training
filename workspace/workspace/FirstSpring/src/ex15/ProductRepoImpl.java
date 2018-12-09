package ex15;

import java.util.List;

public class ProductRepoImpl implements ProductRepo {

	private ProductDao dao;

	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.getProducts();
	}

}

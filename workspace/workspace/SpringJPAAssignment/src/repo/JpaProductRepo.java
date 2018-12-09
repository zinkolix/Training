 package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import entity.Product;

@Repository
public class JpaProductRepo implements ProductRepo {

	@PersistenceContext(unitName = "SpringJPA")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void saveProduct(Product product) {
		entityManager.persist(product);
	}

	@Override
	public Product getProduct(int id) {
		Product p = entityManager.find(Product.class, id);
		return p;
	}

	@Override
	public List<Product> getAll() {
		Query query = entityManager.createQuery("from Product");
		return query.getResultList();
	}

}

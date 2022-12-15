package zinto.express.io.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zinto.express.io.entity.Product;
import zinto.express.io.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product[] product) {	
		return productRepository.saveAll(product);
	}

}

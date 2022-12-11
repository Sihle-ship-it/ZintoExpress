package zinto.express.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import zinto.express.io.entity.Product;
import zinto.express.io.repository.ProductRepository;
import zinto.express.io.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product) {
		System.out.println(product);
		return productService.saveProduct(product);
	}
	
	
}

package zinto.express.io.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zinto.express.io.entity.Product;
import zinto.express.io.entity.Rating;
import zinto.express.io.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	private Product product;
	
	private Rating rating;
	
	@Override
	public Product saveProduct(Product product) {
		//Save Product
		this.product = new Product();
		this.product.setId(product.getId());
		this.product.setTitle(product.getTitle());
		this.product.setPrice(product.getPrice());
		this.product.setDescription(product.getDescription());
		this.product.setCategory(product.getCategory());
		this.product.setImage(product.getImage());
		
		//Save Ratings
		rating = new Rating();
		rating.setRate(product.getRating().getRate());
		rating.setCount(product.getRating().getCount());
		rating.setProduct(this.product);
		this.product.setRating(rating);
		return productRepository.save(this.product);
	}

}
// zinto.express.io.entity.Product.getRating()"
//
//{
//"id": 1,
//"title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//"price": 109.95,
//"description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
//"category": "men's clothing",
//"image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
//"rating": {
//"rate": 3.9,
//"count": 120
//}
//}
package zinto.express.io.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zinto.express.io.entity.Product;

@Repository
public interface ProductRepository extends  JpaRepository<Product, Integer>{

}

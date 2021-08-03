package com.exampl12e.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampl12e.demo.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

		Product findByName(String name);	
	

}

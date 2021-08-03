package com.exampl12e.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampl12e.demo.Entity.Product;
import com.exampl12e.demo.Repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	//POST
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	//POStall
	public List<Product>  saveAllProduct(List<Product> products) {
		return repository.saveAll(products);
	}
	
	//GET
	public Product getProduct(int id) {
		return repository.findById(id).orElse(null);
	}
	
	//GETall	
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }
    
	
	
	public Product updateProduct(Product product) {
		Product existing= repository.findById(product.getId()).orElse(null) ;
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		existing.setQuantity(product.getQuantity());
		return repository.save(existing);
	}
	
	
	
}

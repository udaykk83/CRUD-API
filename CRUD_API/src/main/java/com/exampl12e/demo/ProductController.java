package com.exampl12e.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exampl12e.demo.Entity.Product;
import com.exampl12e.demo.Service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService prodservice;
	
	//POST
	@PostMapping("/addproduct")
	public Product addproduct(@RequestBody Product product) {
		return prodservice.saveProduct(product);
	}
	
	//POSTall
	@PostMapping("/addallproducts")
	public List<Product> addallproducts(@RequestBody List<Product> products){
	 return prodservice.saveAllProduct(products);
	}
	
	@GetMapping("/products")
    public List<Product> findAllProducts() {
        return prodservice.getAllProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return prodservice.getProduct(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return prodservice.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return prodservice.updateProduct(product);
    }
	
	
	
}

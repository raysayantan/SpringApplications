package com.myexample.productrestapidemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.productrestapidemo.entities.Product;
import com.myexample.productrestapidemo.repo.ProductRepository;

@RestController
public class ProductRestController {
	@Autowired
	ProductRepository repository;
	
	@RequestMapping(value="/products",method = RequestMethod.GET)
	public List<Product> getProducts(){
		return repository.findAll();
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product getProductById(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public void CreateProduct(@RequestBody Product p) {
		repository.save(p);
	}
	
	@RequestMapping(value="/products", method=RequestMethod.PUT)
	public void UpdateProduct(@RequestBody Product p) {
		repository.save(p);
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
	public void DeleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);	
	}
}

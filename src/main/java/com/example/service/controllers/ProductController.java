package com.example.service.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.entity.Product;
import com.example.service.services.ProductService;
//import com.netflix.discovery.DiscoveryClient;

@Validated
@RestController
public class ProductController 
{
	
	@Autowired
	private ProductService serv;
	
	//@Autowired
	//private DiscoveryClient dclient;
	//@Autowired
//	private LoadBalancerClient loadbal;

	
	@GetMapping("/")
	public ResponseEntity<List<Product>> GetAll()
	{
		List<Product> prds=serv.GetAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(prds);
	}
	
	//@GetMapping("/")
	//public ResponseEntity<String> Test()
	//{
	//	return ResponseEntity
	//			.status(HttpStatus.OK)
	//			.body("Hello Product World");
	//}
	
		
	@PostMapping("/")
	public ResponseEntity<Product> Add(@RequestBody @Valid Product prd)
	{
		
		Product prdl=serv.addProduct(prd);
		return ResponseEntity.status(HttpStatus.CREATED).body(prdl);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> GetById(@PathVariable int id)
	{
		Product prd=serv.getProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body(prd);
	}
  
	@PutMapping("/")
	public ResponseEntity<Product> Update(@RequestBody Product prd)
	{
		Product prdl=serv.updateProduct(prd);
		return ResponseEntity.ok(prd);
	}
	  
	@DeleteMapping("/{id}")
	public ResponseEntity<String> Delete(@PathVariable int id)
	{
		serv.deleteProduct(serv.getProductById(id));
		return ResponseEntity.ok("Deleted Successfully!");
	}
  

  

	
}



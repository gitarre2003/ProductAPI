package com.example.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.entity.Product;
import com.example.service.repository.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	private ProductsRepository repo;
	
	@Override
	public List<Product> GetAllProducts() {
		return repo.findAll();
	}

	@Override
	public Product addProduct(Product prd) {
		return repo.save(prd);
	}

	@Override
	public Product updateProduct(Product prd) {
		return repo.save(prd);
	}

	@Override
	public void deleteProduct(Product prd) {
		repo.delete(prd);

	}

	@Override
	public Product getProductById(int id) {
		return repo.findById(id).get();
	}

}


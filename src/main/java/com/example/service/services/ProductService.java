package com.example.service.services;

import java.util.List;

import com.example.service.entity.Product;

public interface ProductService 
{
	public List<Product> GetAllProducts();
	public Product addProduct(Product prd);
	public Product updateProduct(Product prd);
	public void deleteProduct(Product prd);
	public Product getProductById(int id);
}

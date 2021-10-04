package com.sportyShoes.service;


import com.sportyShoes.model.Product;

public interface ProductCrudService {
	
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public Product getProductById(int id);
	public void deleteProductById(int id);
	

}

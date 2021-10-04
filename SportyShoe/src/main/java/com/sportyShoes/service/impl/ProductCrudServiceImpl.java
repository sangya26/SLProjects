package com.sportyShoes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyShoes.model.Product;
import com.sportyShoes.repository.ProductRepository;
import com.sportyShoes.service.ProductCrudService;

@Service
public class ProductCrudServiceImpl implements ProductCrudService{
	
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}

	@Override
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
		
	}

}

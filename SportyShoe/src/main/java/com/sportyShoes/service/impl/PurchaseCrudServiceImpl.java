package com.sportyShoes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyShoes.model.Purchase;
import com.sportyShoes.repository.PurchaseRepository;
import com.sportyShoes.service.PurchaseCrudService;

@Service
public class PurchaseCrudServiceImpl implements PurchaseCrudService {
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Override
	public Purchase createPurchase(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}

	@Override
	public Purchase updatePurchase(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}

	@Override
	public Purchase getPurchaseById(int id) {
		return purchaseRepository.findById(id).get();
	}

	@Override
	public void deletePurchaseById(int id) {
		purchaseRepository.deleteById(id);
		
	}

}

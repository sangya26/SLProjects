package com.sportyShoes.service;


import com.sportyShoes.model.Purchase;


public interface PurchaseCrudService {
	
	public Purchase createPurchase(Purchase purchase);
	public Purchase updatePurchase(Purchase purchase);
	public Purchase getPurchaseById(int id);
	public void deletePurchaseById(int id);

}

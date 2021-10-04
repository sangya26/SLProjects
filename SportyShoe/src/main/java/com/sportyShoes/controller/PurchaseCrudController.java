package com.sportyShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyShoes.model.Purchase;
import com.sportyShoes.service.PurchaseCrudService;


@RestController
public class PurchaseCrudController {

	@Autowired
	private PurchaseCrudService purchaseCrudService;
	
	@PostMapping("/createPurchase")
	public Purchase createPurchase(@RequestBody Purchase purchase) {	
		return purchaseCrudService.createPurchase(purchase);
	}

	@PutMapping("/purchase")
	public Purchase updatePurchase(@RequestBody Purchase purchase) {
		return purchaseCrudService.updatePurchase(purchase);
	}

	@GetMapping("/purchase/{purchaseId}")
	public Purchase getPurchaseById(@PathVariable (value="purchaseId") int purchaseId) {
		return purchaseCrudService.getPurchaseById(purchaseId);
	}

	@DeleteMapping("/purchase/{purchaseId}")
	public void deletePurchaseById(@PathVariable (value="purchaseId") int purchaseId) {
		purchaseCrudService.deletePurchaseById(purchaseId);
	}

}

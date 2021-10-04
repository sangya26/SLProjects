package com.sportyShoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyShoes.model.Purchase;
import com.sportyShoes.model.User;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
	
	public List<Purchase> findByUser(User user);
}

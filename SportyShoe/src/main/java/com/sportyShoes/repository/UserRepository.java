package com.sportyShoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyShoes.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByFirstName(String firstName);
	public List<User> findByIsAdmin(boolean isAdmin);
	public User findByEmail (String email);

}

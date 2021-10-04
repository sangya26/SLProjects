package com.sportyShoes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyShoes.model.User;
import com.sportyShoes.repository.UserRepository;
import com.sportyShoes.service.UserCrudService;

@Service
public class UserCrudServiceImpl implements UserCrudService{
	
	 
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}


	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}


}

package com.sportyShoes.service;


import java.util.List;

import com.sportyShoes.model.User;

public interface UserCrudService {
	
	public User createUser(User user);
	public User updateUser(User user);
	public User getUserById(int id);
	public void deleteUserById(int id);
	public List<User> userList();

}

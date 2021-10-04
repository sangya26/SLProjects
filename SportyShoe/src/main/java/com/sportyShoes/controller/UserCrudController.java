package com.sportyShoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyShoes.model.User;
import com.sportyShoes.service.UserCrudService;




//@Api(value="usercrud")
@RestController
public class UserCrudController {
	
	@Autowired
	private UserCrudService userCrudService;
	
	@PostMapping("/createUser")
	public void createUser(@RequestBody User user) {
		List<User> userList=userCrudService.userList();
		if(userList.isEmpty()) {
			userCrudService.createUser(user);
		}else {
			for(User usern:userList) {
				if(!usern.getUserName().equals(user.getUserName())){
					 userCrudService.createUser(user);
				}
			}
		}
	}
	

	@PutMapping("/user")
	public void updateUser( @RequestBody User user) {
		List<User> userList=userCrudService.userList();
		if(userList.isEmpty()) {
			userCrudService.updateUser(user);
		}else {
			for(User usern:userList) {
				if(!usern.getUserName().equals(user.getUserName())){
					userCrudService.updateUser(user);
				}
			}
		}
	}

	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable (value="userId") int userId) {
		return userCrudService.getUserById(userId);
	}
	

	
	public User getUserByUserName(Object object) {
		User user=null;
		for(User i :userCrudService.userList()){
			if(i.getUserName().equals(object)){
				user=i;
			}
		}
			return user;
	}

	@DeleteMapping("/user/{userId}")
	public void deleteUserById(@PathVariable int userId) {
		userCrudService.deleteUserById(userId);
	}
	
	//password change for an admin
	@PutMapping("/passwordChange")
	public void updateUserPassword(@RequestBody User user) {
		//Later: check in session who is the user
		if(getUserByUserName(user.getUserName())!=null){
			User currentUser =getUserByUserName(user.getUserName());
			if(currentUser.getIsAdmin()) {
				userCrudService.updateUser(currentUser);
			}
		}
	}
	
	@PostMapping("/login")
	public String isExistingUser(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		String loginMessage="";
		List<User> userList=userCrudService.userList();
		for(User user :userList) {
			if(userName.equals(user.getUserName())) {
				if(user.getPassword().equals(password)){
					loginMessage="Login Successfuly!";
					
					break;
				}
			}
			loginMessage="Username doesnt exist";
			break;
		}
		return loginMessage;
	}
	


	
}

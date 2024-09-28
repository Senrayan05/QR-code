package com.movieflix.service;

import java.util.List;

import com.movieflix.entities.User;

public interface UserService {
	
	public String registerUser(User user);
	
	public boolean emailExists(String email);
	
	public boolean checkUser(String email, String Password);
	
	public List<User> viewUser();
	
	public User getUser(String email);

	public String updateUser(User user);


}

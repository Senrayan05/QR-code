package com.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.User;
import com.movieflix.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	UserRepository uRepo;


	@Override
	public String registerUser(User user) {
			uRepo.save(user);
				return "Adding user from service";
	}
	
	@Override
	public boolean emailExists(String email) {
		User email_status = uRepo.findByEmail(email);
		if(email_status != null) {
			return true;
		}
		
		return false;
	}


	@Override
	public boolean checkUser(String email, String password) {
		User user = uRepo.findByEmail(email);
		String db_password = user.getPassword();
		
		
		if(db_password.equals(password)) {
		return true;
		}else {
		return false;
			}		
	}

	@Override
	public List<User> viewUser() {
		List<User> userList = uRepo.findAll();
		return userList;
	}

	@Override
	public User getUser(String email) {
		User user = uRepo.findByEmail(email);
		return user;
	}

	@Override
	public String updateUser(User user) {
	        uRepo.save(user); // Update the existing user
	        return "User updated successfully";
 
	}
		
	}

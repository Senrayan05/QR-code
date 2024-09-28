package com.movieflix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.movieflix.entities.Movies;
import com.movieflix.entities.User;

@Controller
public class NavigationController {
	
	@GetMapping("/map-signUp")
	public String registerUser(User user) {
		return "registrationPage.html";
}
	
	@GetMapping("/map-login")
	public String loginUser(User user) {
		return "loginPage.html" ;
	}
	

	@GetMapping("map-addMovie")
	public String addMovie(Movies movie) {
		return "addMovie.html";
	}
	
	
}

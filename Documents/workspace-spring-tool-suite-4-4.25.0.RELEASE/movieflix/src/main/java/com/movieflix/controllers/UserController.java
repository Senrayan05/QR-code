package com.movieflix.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieflix.entities.Movies;
import com.movieflix.entities.User;
import com.movieflix.service.MovieService;
import com.movieflix.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserService uServ;
	
	@Autowired
	MovieService mServ;
	
	@PostMapping("/reg-user")
		public String registerUser(@ModelAttribute User user) {
		boolean status = uServ.emailExists(user.getEmail());
		if(status == true)	{
			System.out.println("user already exists in Database");
			return "loginPage.html";
		}else {
		uServ.registerUser(user);
		return "regSuccess.html";
		}
}	
	
	@PostMapping("/log-user")
	public String ValidateUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
		boolean login_status= uServ.checkUser(email, password);
		if(login_status == true) {
			
			session.setAttribute("email", email);
			
			if(email.equals("admin@gmail.com")) {
				return "adminPage.html";
			}else {
				return "homePage.html";
			}
		}else {
			return "loginFail.html";
		}
		}
	

	@GetMapping("map-viewUser")
	public String viewUser(Model model) {
		List<User> userList = uServ.viewUser();
		model.addAttribute("user", userList);
		return "viewUser.html";
	}
	
	
	@GetMapping("/exploreMovies")  
	public String exploreMovie(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("email");
		
		User user = uServ.getUser(email);
		//checking  whether user is Premium
		boolean status = user.isPremimum();
	
		if(status == true)
		{
			List<Movies> movieList = mServ.viewMovie();
		//adding the movie details in model
			model.addAttribute("movies", movieList);
		//if premium show movies 	
			return "viewmovieUser.html";
		}
		else {
			return "payment.html";
		}
		
	}	
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();		
	    return "loginPage.html";
		
	}
	
}

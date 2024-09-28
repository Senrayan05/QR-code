package com.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.movieflix.entities.Movies;
import com.movieflix.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	MovieService mServ;
	
	
	@PostMapping("/Addmovie")
	public String addMovie(Movies mov) {
		mServ.addMovie(mov);
		return "movieAdded.html";
	}
	
	
	@GetMapping("map-viewMovie")
	public String viewMovie(Model model) {
		 List<Movies> movieList = mServ.viewMovie();
		model.addAttribute("movies", movieList);
		return "viewMovie.html";
	}
	

	@GetMapping("/map-exploreMovie-user")
	public String viewMovieUser(Model model) {
		 List<Movies> movieList = mServ.viewMovie();
		model.addAttribute("movies", movieList);
		return "viewmovieUser.html";
	}


}

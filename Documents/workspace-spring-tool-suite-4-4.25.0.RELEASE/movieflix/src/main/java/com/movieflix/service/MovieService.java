package com.movieflix.service;

import java.util.List;

import org.springframework.ui.Model;

import com.movieflix.entities.Movies;

public interface MovieService {
	public String addMovie(Movies mov);
	
	public List<Movies> viewMovie();
	

}

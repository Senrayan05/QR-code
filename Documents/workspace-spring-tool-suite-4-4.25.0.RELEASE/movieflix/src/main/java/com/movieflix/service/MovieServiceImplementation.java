package com.movieflix.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.Movies;
import com.movieflix.repositories.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService {
	@Autowired
	MovieRepository mRepo;

	@Override
	public String addMovie(Movies mov) {
		mRepo.save(mov);
		return "movie added from service";
	}

	@Override
	public List<Movies> viewMovie() {
		List<Movies> movieList = mRepo.findAll();
		return movieList;
	}
	

}

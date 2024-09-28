package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.Movies;

public interface MovieRepository extends JpaRepository<Movies, Long>{

}

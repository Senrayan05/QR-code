package com.movieflix.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String movieName;
	String movieGenre;
	
	@Column(length = 2000)
	String movieLink;
	
	String movieCast;
	String movieDirector;
	
	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movies(long id, String movieName, String movieGenre, String movieLink, String movieCast,
			String movieDirector) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieLink = movieLink;
		this.movieCast = movieCast;
		this.movieDirector = movieDirector;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieLink() {
		return movieLink;
	}

	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", movieName=" + movieName + ", movieGenre=" + movieGenre + ", movieLink="
				+ movieLink + ", movieCast=" + movieCast + ", movieDirector=" + movieDirector + "]";
	}
	
	
}

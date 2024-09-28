package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.User;



public interface UserRepository extends JpaRepository<User,Long>{
	
	boolean existsByEmail(String email);

	public User findByEmail(String email);

}

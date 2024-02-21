package com.educandoweb.cuorse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.cuorse.entities.User;

//ao instanciar UserRepository teremos varis operações herdadas JpaRepository
public interface UserRepository  extends JpaRepository<User, Long>{
	

}

package com.ufc.web.heroes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.web.heroes.model.Heroe;
import com.ufc.web.heroes.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> getByEmail(String email);	
}

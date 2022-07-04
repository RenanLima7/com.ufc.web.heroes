package com.ufc.web.heroes.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.web.heroes.model.User;
import com.ufc.web.heroes.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	public Optional<User> getByEmail(String email) {
		return userRepository.getByEmail(email);
	}
}



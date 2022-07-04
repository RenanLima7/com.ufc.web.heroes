package com.ufc.web.heroes.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ufc.web.heroes.dto.HeroeDTO;
import com.ufc.web.heroes.dto.UserDTO;
import com.ufc.web.heroes.model.Heroe;
import com.ufc.web.heroes.model.User;
import com.ufc.web.heroes.service.HeroeService;
import com.ufc.web.heroes.service.UserService;
import com.ufc.web.heroes.service.UtilityMethods;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid UserDTO userDTO){
		var user = new User();		
		BeanUtils.copyProperties(userDTO, user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}		

	@PostMapping("/login")
	public ResponseEntity<Object> userLogin(@RequestHeader String basicAuth) { 
		
		Boolean valid = true;
	
		//Optional<User> userOptional = userService.getByEmail(email);
		
		//if (!userOptional.isPresent()) {
			//return new ResponseEntity<Object>("There is no user with the email: " + email, HttpStatus.UNAUTHORIZED);
		//}
		
		//User user = userOptional.get();
		//boolean valid = UtilityMethods.compareEncryptedPassword(password, user.getPass());
		
		if(valid) {
			return new ResponseEntity<Object>("AUTHORIZED", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Object>("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
		}
	}
}

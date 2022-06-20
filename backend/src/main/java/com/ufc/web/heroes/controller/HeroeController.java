package com.ufc.web.heroes.controller;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ufc.web.heroes.dto.HeroeDTO;
import com.ufc.web.heroes.model.Heroe;
import com.ufc.web.heroes.service.HeroeService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/heroes")
public class HeroeController {

	@Autowired
	HeroeService heroeService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid HeroeDTO heroeDTO){
		var heroe = new Heroe();		
		BeanUtils.copyProperties(heroeDTO, heroe);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(heroeService.save(heroe));
	}
	
	@GetMapping
	public ResponseEntity<Object> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(heroeService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getHeroeById(@PathVariable(value = "id") UUID id){
		Optional<Heroe> heroeOptional = heroeService.getHeroeById(id);
		
		if (!heroeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hero found with id: " + id);
		}
		return ResponseEntity.status(HttpStatus.OK).body(heroeOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id){
		Optional<Heroe> heroeOptional = heroeService.getHeroeById(id);
		
		if (!heroeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hero found with id: " + id);
		}
		
		heroeService.delete(heroeOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Hero successfully deleted!");
	}

	@PutMapping("/id")
	public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid HeroeDTO heroeDTO){
		Optional<Heroe> heroeOptional = heroeService.getHeroeById(id);
		
		if (!heroeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hero found with id: " + id);
		}
		
		var heroe = heroeOptional.get();
		//heroe.setName(heroeDTO.getName());
				
		return ResponseEntity.status(HttpStatus.OK).body(heroeService.save(heroe));
	}
}

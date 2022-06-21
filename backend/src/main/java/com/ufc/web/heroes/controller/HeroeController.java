package com.ufc.web.heroes.controller;

import java.util.Optional;

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
	public Iterable<Heroe> getAll(){
		return heroeService.getAll();
	}
	
	@GetMapping("/{id}")
	public Object getHeroeById(@PathVariable(value = "id") Integer id){
		Optional<Heroe> heroeOptional = heroeService.getHeroeById(id);
		
		if (!heroeOptional.isPresent()) {
			return "No hero found with id: " + id;
		}
		return heroeOptional.get();
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable(value = "id") Integer id){
		Optional<Heroe> heroeOptional = heroeService.getHeroeById(id);
		
		if (!heroeOptional.isPresent()) {
			return "No hero found with id: " + id;
		}
		
		heroeService.delete(heroeOptional.get());
		return "Hero successfully deleted!";
	}

	@PutMapping("/{id}")
	public Object update(@PathVariable(value = "id") Integer id, @RequestBody @Valid HeroeDTO heroeDTO){
		Optional<Heroe> heroeOptional = heroeService.getHeroeById(id);
		
		if (!heroeOptional.isPresent()) {
			return "No hero found with id: " + id;
		}
		
		var heroe = heroeOptional.get();
		heroe.setName(heroeDTO.getName());
		
		heroeService.save(heroe);
				
		return heroeService.getHeroeById(id);
	}
}

package com.ufc.web.heroes.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.web.heroes.model.Heroe;
import com.ufc.web.heroes.repository.HeroeRepository;

@Service
public class HeroeService {
	@Autowired
	HeroeRepository heroeRepository;
	
	@Transactional
	public Heroe save(Heroe heroe) {
		return heroeRepository.save(heroe);
	}
	
	public Iterable<Heroe> getAll() {
		return heroeRepository.findAll();
	}
	
	public Optional<Heroe> getHeroeById(Integer id){
		return heroeRepository.findById(id);
	}
	
	@Transactional
	public void delete(Heroe heroe){
		heroeRepository.delete(heroe); 
	}
}



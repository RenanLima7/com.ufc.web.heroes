package com.ufc.web.heroes.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.web.heroes.model.Heroe;

@Repository
public interface HeroeRepository extends JpaRepository<Heroe, Integer>{
	
}

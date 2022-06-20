package com.ufc.web.heroes.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ufc.web.heroes.model.Heroe;

@Repository
public interface HeroeRepository extends CrudRepository<Heroe, UUID>{

}

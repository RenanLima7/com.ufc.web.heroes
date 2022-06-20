package com.ufc.web.heroes.model;

import java.util.UUID;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Heroe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HeroeId")
	private UUID id;
	
	@Column(name = "HeroeName", length = 100, nullable = false)
	private String name;
}

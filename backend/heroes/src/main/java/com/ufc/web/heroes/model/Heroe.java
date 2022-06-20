package com.ufc.web.heroes.model;

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
	private Integer id;
	@Column(name = "HeroeName", length = 100)
	private String name;
}

package com.ufc.web.heroes.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Heroe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	public Heroe(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Heroe(String name) {
		super();
		this.name = name;
	}
	
	public Heroe() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() { 
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

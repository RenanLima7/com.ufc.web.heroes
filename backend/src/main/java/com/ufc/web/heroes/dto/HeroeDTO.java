package com.ufc.web.heroes.dto;

import javax.validation.constraints.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroeDTO {
	@NotBlank
	@NotNull	
	private String name;
	
	public HeroeDTO(String name) {
		super();
		this.name = name;
	}
	
	public HeroeDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}

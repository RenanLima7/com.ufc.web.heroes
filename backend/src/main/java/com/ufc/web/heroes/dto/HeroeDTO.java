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
}

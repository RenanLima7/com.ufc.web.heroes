package com.ufc.web.heroes.dto;

import javax.validation.constraints.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@NotBlank
	@NotNull	
	private String email;
	
	@NotBlank
	@NotNull	
	private String pass;		

	public UserDTO(@NotBlank @NotNull String email, @NotBlank @NotNull String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	public UserDTO() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}

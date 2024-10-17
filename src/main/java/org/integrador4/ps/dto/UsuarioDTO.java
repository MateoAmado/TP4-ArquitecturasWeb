package org.integrador4.ps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
public class UsuarioDTO {

	private String password;
	private String email;
	private String rol;


    public UsuarioDTO(String email, String password){
		this.email = email;
		this.password = password;
	}

}

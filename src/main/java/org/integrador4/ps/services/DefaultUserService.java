package org.integrador4.ps.services;

import org.integrador4.ps.dto.UsuarioDTO;
import org.integrador4.ps.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface DefaultUserService extends UserDetailsService {
	Usuario save(UsuarioDTO usuario_dto);

	UserDetails loadUserByUsername(String email);
}

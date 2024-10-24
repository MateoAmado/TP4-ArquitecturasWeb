package org.integrador4.ps.auth_service.Service;

import org.integrador4.ps.auth_service.dto.UsuarioDTO;
import org.integrador4.ps.auth_service.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface DefaultUserService extends UserDetailsService {
    Usuario save(UsuarioDTO usuario_dto);



    UserDetails loadUserByUsername(String email);
}

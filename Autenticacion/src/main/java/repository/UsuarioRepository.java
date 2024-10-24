package org.integrador4.ps.auth_service.repository;

import org.integrador4.ps.auth_service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.email =:email")
    Usuario findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.password =:password")
    Usuario findByPassword(String password);
}


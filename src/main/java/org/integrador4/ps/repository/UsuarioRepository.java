package org.integrador4.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.integrador4.ps.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);
}


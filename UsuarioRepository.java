package com.projetojpa.Validation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.Validation.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

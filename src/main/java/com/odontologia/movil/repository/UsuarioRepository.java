package com.odontologia.movil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odontologia.movil.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

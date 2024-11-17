package com.odontologia.movil.service;

import java.util.List;
import java.util.Optional;

import com.odontologia.movil.entidades.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll();

	Optional<Usuario> findById(Integer id);

	Usuario save(Usuario usuario);

	void deleteById(Integer id);

}

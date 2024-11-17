package com.odontologia.movil.service;

import java.util.List;
import java.util.Optional;

import com.odontologia.movil.entidades.TipoPersona;

public interface TipoPersonaService {
	
	List<TipoPersona> findAll();

	Optional<TipoPersona> findById(Integer id);

	TipoPersona save(TipoPersona tipoPersona);

	void deleteById(Integer id);

}

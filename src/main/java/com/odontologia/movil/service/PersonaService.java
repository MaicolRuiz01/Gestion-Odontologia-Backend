package com.odontologia.movil.service;

import java.util.List;
import java.util.Optional;

import com.odontologia.movil.dto.PersonaDTO;
import com.odontologia.movil.entidades.Persona;

public interface PersonaService {

	List<Persona> findAll();

	Optional<Persona> findById(Integer id);

	Persona save(Persona persona);

	void deleteById(Integer id);
	List<Persona> findAllByTipoPersonaId(Integer tipoId);
	List<PersonaDTO> findAllByTipoPersonaIdDTO(Integer tipoId);


}

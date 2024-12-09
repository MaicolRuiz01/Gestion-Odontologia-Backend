package com.odontologia.movil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odontologia.movil.entidades.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	@Query("SELECT p FROM Persona p WHERE p.tipopersona.id = :tipoId")
    List<Persona> findAllByTipoPersonaId(@Param("tipoId") Integer tipoId);
	


}

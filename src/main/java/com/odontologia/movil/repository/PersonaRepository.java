package com.odontologia.movil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odontologia.movil.entidades.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}

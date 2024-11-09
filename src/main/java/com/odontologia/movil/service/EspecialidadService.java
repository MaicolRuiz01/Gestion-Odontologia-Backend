package com.odontologia.movil.service;

import java.util.List;
import java.util.Optional;

import com.odontologia.movil.entidades.Especialidad;

public interface EspecialidadService {
	
	List<Especialidad> findAll();

    Optional<Especialidad> findById(Integer id);

    Especialidad save(Especialidad especialidad);

    void deleteById(Integer id);

}

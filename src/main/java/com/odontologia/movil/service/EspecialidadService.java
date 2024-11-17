package com.odontologia.movil.service;

import java.util.List;
import java.util.Optional;

import com.odontologia.movil.entidades.Especialidad;

public interface EspecialidadService {
	
	List<Especialidad> findAll();
    Especialidad findById(Integer id);
    Especialidad save(Especialidad especialidad);
    Especialidad update(Integer id, Especialidad especialidadDetails);
    void delete(Integer id);

}

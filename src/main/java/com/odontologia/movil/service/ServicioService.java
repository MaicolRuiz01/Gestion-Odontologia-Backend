package com.odontologia.movil.service;

import java.util.List;
import java.util.Optional;

import com.odontologia.movil.entidades.Servicio;

public interface ServicioService {
	
	List<Servicio> findAll();

	Optional<Servicio> findById(Integer id);

	Servicio save(Servicio servicio);

	void deleteById(Integer id);

	List<Servicio> findByPacienteId(Integer pacienteId);

	List<Servicio> findByLaboratorioId(Integer laboratorioId);

}

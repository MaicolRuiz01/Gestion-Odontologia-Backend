package com.odontologia.movil.service;

import java.util.List;
import java.util.Optional;

import com.odontologia.movil.dto.CitaDTO;
import com.odontologia.movil.entidades.Cita;

public interface CitaService {
	
    List<Cita> findAll();

    Optional<Cita> findById(Integer id);

    Cita save(Cita cita);

    void deleteById(Integer id);

    List<Cita> findByPacienteId(Integer pacienteId);

    List<Cita> findByOdontologoId(Integer odontologoId);

	List<Cita> getAllCitas();

	Optional<Cita> getCitaById(Integer id);

	void deleteCita(Integer id);

	List<CitaDTO> getAllCitasDTO();

}

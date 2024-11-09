package com.odontologia.movil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odontologia.movil.entidades.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
	
	List<Cita> findByPaciente_Id(Integer pacienteId);

    List<Cita> findByOdontologo_Id(Integer odontologoId);
}

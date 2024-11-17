package com.odontologia.movil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odontologia.movil.entidades.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

	List<Servicio> findByLaboratorio_Id(Integer laboratorioId);

	List<Servicio> findByPaciente_Id(Integer pacienteId);


}

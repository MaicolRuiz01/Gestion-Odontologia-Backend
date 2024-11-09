package com.odontologia.movil.service;

import java.util.List;
import java.util.Optional;



import com.odontologia.movil.entidades.Laboratorio;


public interface LaboratorioService {
	
	List<Laboratorio> findAll();

    Optional<Laboratorio> findById(Integer id);

    Laboratorio save(Laboratorio laboratorio);

    void deleteById(Integer id);

}

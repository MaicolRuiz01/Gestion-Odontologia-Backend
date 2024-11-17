package com.odontologia.movil.service;

import java.util.List;
import java.util.Optional;

import com.odontologia.movil.entidades.Rol;

public interface RolService {
	
	List<Rol> findAll();

    Optional<Rol> findById(Integer id);

    Rol save(Rol rol);

    void deleteById(Integer id);

}

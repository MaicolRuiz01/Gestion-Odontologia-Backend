package com.odontologia.movil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odontologia.movil.entidades.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}

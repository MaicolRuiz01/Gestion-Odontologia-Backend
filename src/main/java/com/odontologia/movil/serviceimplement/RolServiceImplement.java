package com.odontologia.movil.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odontologia.movil.entidades.Rol;
import com.odontologia.movil.repository.RolRepository;
import com.odontologia.movil.service.RolService;

@Service
public class RolServiceImplement implements RolService{
	
	private final RolRepository rolRepository;

    @Autowired
    public RolServiceImplement(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Rol> findById(Integer id) {
        return rolRepository.findById(id);
    }

    @Override
    @Transactional
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        rolRepository.deleteById(id);
    }

}

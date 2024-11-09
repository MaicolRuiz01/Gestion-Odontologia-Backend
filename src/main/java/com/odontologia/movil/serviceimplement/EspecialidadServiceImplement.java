package com.odontologia.movil.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odontologia.movil.entidades.Especialidad;
import com.odontologia.movil.repository.EspecialidadRepository;
import com.odontologia.movil.service.EspecialidadService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class EspecialidadServiceImplement implements EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadServiceImplement(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Transactional(readOnly = true)
    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Especialidad> findById(Integer id) {
        return especialidadRepository.findById(id);
    }

    @Transactional
    public Especialidad save(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Transactional
    public void deleteById(Integer id) {
        especialidadRepository.deleteById(id);
    }
}

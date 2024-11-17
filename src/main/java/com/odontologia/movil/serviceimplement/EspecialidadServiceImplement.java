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

    @Override
    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad findById(Integer id) {
        return especialidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada con ID: " + id));
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad update(Integer id, Especialidad especialidadDetails) {
        Especialidad especialidad = findById(id);
        especialidad.setDescripcion(especialidadDetails.getDescripcion());
        return especialidadRepository.save(especialidad);
    }

    @Override
    public void delete(Integer id) {
        Especialidad especialidad = findById(id);
        especialidadRepository.delete(especialidad);
    }
}

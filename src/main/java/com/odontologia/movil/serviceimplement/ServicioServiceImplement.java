package com.odontologia.movil.serviceimplement;

import com.odontologia.movil.entidades.Servicio;
import com.odontologia.movil.repository.ServicioRepository;
import com.odontologia.movil.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImplement implements ServicioService{
	
	private final ServicioRepository servicioRepository;

    @Autowired
    public ServicioServiceImplement(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Servicio> findById(Integer id) {
        return servicioRepository.findById(id);
    }

    @Override
    @Transactional
    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        servicioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> findByPacienteId(Integer pacienteId) {
        return servicioRepository.findByPaciente_Id(pacienteId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> findByLaboratorioId(Integer laboratorioId) {
        return servicioRepository.findByLaboratorio_Id(laboratorioId);
    }

}

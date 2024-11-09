package com.odontologia.movil.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odontologia.movil.entidades.Cita;
import com.odontologia.movil.repository.CitaRepository;
import com.odontologia.movil.service.CitaService;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImplement implements CitaService{
	
	private final CitaRepository citaRepository;

    @Autowired
    public CitaServiceImplement(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cita> findById(Integer id) {
        return citaRepository.findById(id);
    }

    @Override
    @Transactional
    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        citaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findByPacienteId(Integer pacienteId) {
        return citaRepository.findByPaciente_Id(pacienteId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findByOdontologoId(Integer odontologoId) {
        return citaRepository.findByOdontologo_Id(odontologoId);
    }

	@Override
	public List<Cita> getAllCitas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cita> getCitaById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteCita(Integer id) {
		// TODO Auto-generated method stub
		
	}
}

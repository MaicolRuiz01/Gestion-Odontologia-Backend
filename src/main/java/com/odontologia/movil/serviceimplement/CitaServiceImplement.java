package com.odontologia.movil.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odontologia.movil.dto.CitaDTO;
import com.odontologia.movil.entidades.Cita;
import com.odontologia.movil.repository.CitaRepository;
import com.odontologia.movil.service.CitaService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	@Override
	@Transactional(readOnly = true)
	public List<CitaDTO> getAllCitasDTO() {
	    return citaRepository.findAll().stream().map(cita -> {
	        // Verificar si el campo fechaNacimiento es nulo
	        int pacienteEdad = (cita.getPaciente().getFechaNacimiento() != null)
	                ? new Date().getYear() - cita.getPaciente().getFechaNacimiento().getYear()
	                : 0; // Edad predeterminada si fechaNacimiento es nula

	        // Calcular días restantes para la cita
	        long diasRestantes = (cita.getFecha().getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24);

	        // Crear y devolver el DTO
	        return new CitaDTO(
	                cita.getPaciente().getNombre(),
	                pacienteEdad,
	                cita.getOdontologo().getNombre(),
	                cita.getOdontologo().getEspecialidad() != null ? cita.getOdontologo().getEspecialidad().getDescripcion() : "Sin especialidad",
	                cita.getTratamiento(),
	                cita.getDescripcion(),
	                cita.getFecha(),
	                diasRestantes,
	                cita.getValor(),
	                cita.getPagado()
	        );
	    }).collect(Collectors.toList());
	}

}

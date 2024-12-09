package com.odontologia.movil.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odontologia.movil.repository.PersonaRepository;
import com.odontologia.movil.service.PersonaService;
import com.odontologia.movil.dto.PersonaDTO;
import com.odontologia.movil.entidades.Persona;
import java.util.stream.Collectors;


@Service
public class PersonaServiceImplement implements PersonaService{
	
	private final PersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImplement(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Integer id) {
        return personaRepository.findById(id);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        personaRepository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAllByTipoPersonaId(Integer tipoId) {
        return personaRepository.findAllByTipoPersonaId(tipoId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<PersonaDTO> findAllByTipoPersonaIdDTO(Integer tipoId) {
        return personaRepository.findAllByTipoPersonaId(tipoId).stream()
                .map(persona -> new PersonaDTO(
                		
                        persona.getNombre(),
                        persona.getCedula(),
                        persona.getFechaNacimiento())) // Aquí se usa el constructor.
                .collect(Collectors.toList());
    }



}

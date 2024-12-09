package com.odontologia.movil.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odontologia.movil.dto.PersonaDTO;
import com.odontologia.movil.entidades.Persona;
import com.odontologia.movil.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
	
	private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = personaService.findAll();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Integer id) {
        Optional<Persona> persona = personaService.findById(id);
        return persona.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        Persona newPersona = personaService.save(persona);
        return new ResponseEntity<>(newPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Integer id, @RequestBody Persona persona) {
        Optional<Persona> existingPersona = personaService.findById(id);
        if (existingPersona.isPresent()) {
            persona.setId(id);
            Persona updatedPersona = personaService.save(persona);
            return new ResponseEntity<>(updatedPersona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Integer id) {
        if (personaService.findById(id).isPresent()) {
            personaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
 // Endpoint para obtener todos los odontólogos
    @GetMapping("/odontologos")
    public ResponseEntity<List<PersonaDTO>> getAllOdontologos() {
        List<PersonaDTO> odontologos = personaService.findAllByTipoPersonaIdDTO(1); // Asumiendo que 1 es el ID para odontólogos
        return new ResponseEntity<>(odontologos, HttpStatus.OK);
    }

    // Endpoint para obtener todos los pacientes
 // Endpoint para obtener todos los pacientes
    @GetMapping("/pacientes")
    public ResponseEntity<List<PersonaDTO>> getAllPacientes() {
        List<PersonaDTO> pacientes = personaService.findAllByTipoPersonaIdDTO(2); // ID para pacientes
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

}

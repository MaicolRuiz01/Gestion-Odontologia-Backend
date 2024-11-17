package com.odontologia.movil.controller;

import java.util.List;

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

import com.odontologia.movil.entidades.Especialidad;
import com.odontologia.movil.service.EspecialidadService;

@RestController
@RequestMapping("/api/especialidad")
public class EspecialidadController {

private final EspecialidadService especialidadService;
    
    @Autowired
    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }
    
    // Obtener todas las especialidades
    @GetMapping
    public ResponseEntity<List<Especialidad>> getAllEspecialidad() {
        List<Especialidad> especialidades = especialidadService.findAll();
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }
    
    // Obtener una especialidad por ID
    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable("id") Integer id) {
        Especialidad especialidad = especialidadService.findById(id);
        return new ResponseEntity<>(especialidad, HttpStatus.OK);
    }
    
    // Crear una nueva especialidad
    @PostMapping
    public ResponseEntity<Especialidad> createEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad newEspecialidad = especialidadService.save(especialidad);
        return new ResponseEntity<>(newEspecialidad, HttpStatus.CREATED);
    }
    
    // Actualizar una especialidad existente
    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> updateEspecialidad(
            @PathVariable("id") Integer id,
            @RequestBody Especialidad especialidadDetails) {
        Especialidad updatedEspecialidad = especialidadService.update(id, especialidadDetails);
        return new ResponseEntity<>(updatedEspecialidad, HttpStatus.OK);
    }
    
    // Eliminar una especialidad por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable("id") Integer id) {
        especialidadService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

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

import com.odontologia.movil.entidades.Servicio;
import com.odontologia.movil.service.ServicioService;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {
	
	private final ServicioService servicioService;

    @Autowired
    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> getAllServicios() {
        List<Servicio> servicios = servicioService.findAll();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable Integer id) {
        Optional<Servicio> servicio = servicioService.findById(id);
        return servicio.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Servicio> createServicio(@RequestBody Servicio servicio) {
        Servicio newServicio = servicioService.save(servicio);
        return new ResponseEntity<>(newServicio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> updateServicio(@PathVariable Integer id, @RequestBody Servicio servicio) {
        Optional<Servicio> existingServicio = servicioService.findById(id);
        if (existingServicio.isPresent()) {
            servicio.setId(id);
            Servicio updatedServicio = servicioService.save(servicio);
            return new ResponseEntity<>(updatedServicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Integer id) {
        if (servicioService.findById(id).isPresent()) {
            servicioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Servicio>> getServiciosByPacienteId(@PathVariable Integer pacienteId) {
        List<Servicio> servicios = servicioService.findByPacienteId(pacienteId);
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    @GetMapping("/laboratorio/{laboratorioId}")
    public ResponseEntity<List<Servicio>> getServiciosByLaboratorioId(@PathVariable Integer laboratorioId) {
        List<Servicio> servicios = servicioService.findByLaboratorioId(laboratorioId);
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

}

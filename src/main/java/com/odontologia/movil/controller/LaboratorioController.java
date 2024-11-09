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

import com.odontologia.movil.service.LaboratorioService;
import com.odontologia.movil.entidades.Laboratorio;

@RestController
@RequestMapping("/api/laboratorios")
public class LaboratorioController {
	
	
	private final LaboratorioService laboratorioService;

    @Autowired
    public LaboratorioController(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    @GetMapping
    public ResponseEntity<List<Laboratorio>> getAllLaboratorios() {
        List<Laboratorio> laboratorios = laboratorioService.findAll();
        return new ResponseEntity<>(laboratorios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> getLaboratorioById(@PathVariable Integer id) {
        Optional<Laboratorio> laboratorio = laboratorioService.findById(id);
        return laboratorio.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Laboratorio> createLaboratorio(@RequestBody Laboratorio laboratorio) {
        Laboratorio newLaboratorio = laboratorioService.save(laboratorio);
        return new ResponseEntity<>(newLaboratorio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratorio> updateLaboratorio(@PathVariable Integer id, @RequestBody Laboratorio laboratorio) {
        Optional<Laboratorio> existingLaboratorio = laboratorioService.findById(id);
        if (existingLaboratorio.isPresent()) {
            laboratorio.setId(id);
            Laboratorio updatedLaboratorio = laboratorioService.save(laboratorio);
            return new ResponseEntity<>(updatedLaboratorio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaboratorio(@PathVariable Integer id) {
        if (laboratorioService.findById(id).isPresent()) {
            laboratorioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

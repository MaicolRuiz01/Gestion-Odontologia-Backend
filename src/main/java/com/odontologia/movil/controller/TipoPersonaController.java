package com.odontologia.movil.controller;


import com.odontologia.movil.entidades.TipoPersona;
import com.odontologia.movil.service.TipoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipo-persona")
public class TipoPersonaController {
	
	private final TipoPersonaService tipoPersonaService;

    @Autowired
    public TipoPersonaController(TipoPersonaService tipoPersonaService) {
        this.tipoPersonaService = tipoPersonaService;
    }

    @GetMapping
    public ResponseEntity<List<TipoPersona>> getAllTipoPersonas() {
        List<TipoPersona> tipoPersonas = tipoPersonaService.findAll();
        return new ResponseEntity<>(tipoPersonas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPersona> getTipoPersonaById(@PathVariable Integer id) {
        Optional<TipoPersona> tipoPersona = tipoPersonaService.findById(id);
        return tipoPersona.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TipoPersona> createTipoPersona(@RequestBody TipoPersona tipoPersona) {
        TipoPersona newTipoPersona = tipoPersonaService.save(tipoPersona);
        return new ResponseEntity<>(newTipoPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPersona> updateTipoPersona(@PathVariable Integer id, @RequestBody TipoPersona tipoPersona) {
        Optional<TipoPersona> existingTipoPersona = tipoPersonaService.findById(id);
        if (existingTipoPersona.isPresent()) {
            tipoPersona.setId(id);
            TipoPersona updatedTipoPersona = tipoPersonaService.save(tipoPersona);
            return new ResponseEntity<>(updatedTipoPersona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPersona(@PathVariable Integer id) {
        if (tipoPersonaService.findById(id).isPresent()) {
            tipoPersonaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

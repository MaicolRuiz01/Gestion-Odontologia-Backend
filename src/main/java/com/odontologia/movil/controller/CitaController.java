package com.odontologia.movil.controller;

import com.odontologia.movil.dto.CitaDTO;
import com.odontologia.movil.entidades.Cita;
import com.odontologia.movil.service.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    // Obtener todas las citas
    @GetMapping
    public ResponseEntity<List<CitaDTO>> getAllCitas() {
        List<CitaDTO> citas = citaService.getAllCitasDTO();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
    // Obtener una cita por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable Integer id) {
        Optional<Cita> cita = citaService.findById(id);
        return cita.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear una nueva cita
    @PostMapping
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita newCita = citaService.save(cita);
        return new ResponseEntity<>(newCita, HttpStatus.CREATED);
    }

    // Actualizar una cita existente
    @PutMapping("/{id}")
    public ResponseEntity<Cita> updateCita(@PathVariable Integer id, @RequestBody Cita citaDetails) {
        Optional<Cita> existingCita = citaService.findById(id);

        if (existingCita.isPresent()) {
            Cita citaToUpdate = existingCita.get();
            citaToUpdate.setPaciente(citaDetails.getPaciente());
            citaToUpdate.setOdontologo(citaDetails.getOdontologo());
            citaToUpdate.setTratamiento(citaDetails.getTratamiento());
            citaToUpdate.setDescripcion(citaDetails.getDescripcion());
            citaToUpdate.setFecha(citaDetails.getFecha());
            citaToUpdate.setValor(citaDetails.getValor());
            citaToUpdate.setPagado(citaDetails.getPagado());
            
            Cita updatedCita = citaService.save(citaToUpdate);
            return new ResponseEntity<>(updatedCita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una cita por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Integer id) {
        Optional<Cita> existingCita = citaService.findById(id);
        
        if (existingCita.isPresent()) {
            citaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener citas por ID de paciente
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Cita>> getCitasByPacienteId(@PathVariable Integer pacienteId) {
        List<Cita> citas = citaService.findByPacienteId(pacienteId);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    // Obtener citas por ID de odontólogo
    @GetMapping("/odontologo/{odontologoId}")
    public ResponseEntity<List<Cita>> getCitasByOdontologoId(@PathVariable Integer odontologoId) {
        List<Cita> citas = citaService.findByOdontologoId(odontologoId);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
}

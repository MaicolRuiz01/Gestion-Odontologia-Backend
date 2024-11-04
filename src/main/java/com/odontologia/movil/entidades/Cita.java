package com.odontologia.movil.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cita")
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Persona paciente;
    
    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Persona odontologo;
    
    private String tratamiento;
    private String descripcion;
    private Date fecha;
    private Double valor;
    private Boolean pagado;
}
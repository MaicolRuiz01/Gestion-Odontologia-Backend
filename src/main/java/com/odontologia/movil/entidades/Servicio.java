package com.odontologia.movil.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="servicio")
public class Servicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Persona paciente;
    
    @ManyToOne
    @JoinColumn(name = "laboratorio_id")
    private Laboratorio laboratorio;
    
    private Date fechaInicio;
    private Date fechaEntrega;
    private Double costo;
    private Boolean pago;
}

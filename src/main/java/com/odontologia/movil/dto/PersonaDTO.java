package com.odontologia.movil.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
	
	private String nombre;
    private String cedula;
    private Date fechaNacimiento;
    private String gmail;
    
    public PersonaDTO(String nombre, String cedula, Date fechaNacimiento) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
    }

}

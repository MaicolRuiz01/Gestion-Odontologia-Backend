package com.odontologia.movil.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {
	private Integer id;
	private String pacienteNombre;
    private int pacienteEdad;
    private String odontologoNombre;
    private String odontologoEspecialidad;
    private String tratamiento;
    private String descripcion;
    private Date fecha;
    private long diasRestantes;
    private Double valor;
    private Boolean pagado;

}

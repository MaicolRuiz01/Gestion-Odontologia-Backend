package com.odontologia.movil.entidades;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class CuentaBancaria {
	
	private Integer id;
	private Persona propietario;
	private Double monto;
	private Movimiento movimientos;
	private String banco;
	
}

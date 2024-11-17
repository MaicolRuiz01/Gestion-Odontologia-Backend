package com.odontologia.movil.entidades;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class Persona {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private String cedula;
	private Date fechaNacimiento; 
    
	
	  @ManyToOne
	  @JoinColumn(name = "tipo_persona_id") 
	  private TipoPersona tipopersona;
	  
	  @ManyToOne
	  @JoinColumn(name = "especialidad_id") 
	  private Especialidad especialidad;
	  
	  @OneToMany(mappedBy = "paciente") 
	  private List<Servicio> serviciosRecibidos;
	 

}

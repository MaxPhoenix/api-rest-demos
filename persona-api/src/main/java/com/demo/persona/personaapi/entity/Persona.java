package com.demo.persona.personaapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Persona {

	private Integer id;
	private String nombre;
	private String apellido;
	private Double altura;
	private String email;
	private Integer edad;
	
}

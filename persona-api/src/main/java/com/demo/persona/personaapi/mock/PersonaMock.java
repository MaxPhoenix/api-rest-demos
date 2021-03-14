package com.demo.persona.personaapi.mock;


import com.demo.persona.personaapi.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaMock {
	private List<Persona> personaMock;
	private int id;
		
	public PersonaMock() {
		personaMock = new ArrayList<>();
		id = 1;
	}
	
	public List<Persona> listar() {
		return personaMock;
	}

	public Persona crear(Persona persona) throws Exception {
		if(buscarPorId(persona.getId()) != null) {
			System.out.println("Esa persona ya existe");
			throw new Exception("Registro ya existente.");
		}
		else {
			persona.setId(id);
			personaMock.add(persona);
			id++;
			
			return persona;
		}
	
	}

	public boolean borrar(Integer id) {
		Persona persona = buscarPorId(id);
		
		if(persona != null) {
			personaMock.remove(persona);			
		}
		else {
			System.out.println("Persona no encontrada");
		}
		
		return persona != null;
	}
	
	public Persona buscarPorId(Integer id) {
		for (int i = 0; personaMock != null && i < personaMock.size(); i++) {
			if(personaMock.get(i).getId().equals(id)) {
				return personaMock.get(i);
			}				
		}
				
		return null;
	}

	public void modificar(Persona persona) {
		boolean registroModificado = false;
		for (int i = 0; !registroModificado && i < personaMock.size(); i++) {
			registroModificado = personaMock.get(i).getId().equals(persona.getId());			
			if(registroModificado) {
				personaMock.set(i, persona);
			}				
		}
		
		if(!registroModificado) {
			System.out.println("Persona no encontrada");
		}
	}

	public Persona listarPorId(Integer id) {
		Persona persona = null;
		
		for (int i = 0; i < personaMock.size(); i++) {
			if(personaMock.get(i).getId().equals(id)) {
				persona = personaMock.get(i);
			}				
		}
		
		return persona;
	}

	public Persona obtenerPersonaPorEmail(String email) {
		Persona persona = null;
		
		for (int i = 0; i < personaMock.size(); i++) {
			if(personaMock.get(i).getEmail().equals(email)) {
				persona = personaMock.get(i);
			}				
		}
		
		return persona;
	}
}
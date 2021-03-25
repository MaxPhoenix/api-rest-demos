package com.demo.persona.personaapi.dao;

import com.demo.persona.personaapi.entity.Persona;
import com.demo.persona.personaapi.exception.DuplicateKeyException;
import com.demo.persona.personaapi.mock.PersonaMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;


@Repository
public class PersonaDao {
    
    @Autowired
    private PersonaMock personaMock;

    public List<Persona> listar() {
		
		return personaMock.listar();
	}

	public Persona crear(Persona persona) throws DuplicateKeyException {
		try {
			return personaMock.crear(persona);
		} 
		catch (DuplicateKeyException e) {
			throw new DuplicateKeyException("Ya existe una persona con ese email y/o ID");
		}
	}

	public void borrar(Integer id) throws NoSuchElementException {
		try {
			personaMock.borrar(id);
		} 
		catch (NoSuchElementException e) {
			throw new NoSuchElementException("La persona a Borrar no existe");
		}
	}

	public void modificar(Persona persona) throws NoSuchElementException {
		try {
			personaMock.modificar(persona);
		} 
		catch (NoSuchElementException e) {
			throw new NoSuchElementException("La persona a Modificar no existe");
		}
	}
}

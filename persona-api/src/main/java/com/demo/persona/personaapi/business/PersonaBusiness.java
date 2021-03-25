package com.demo.persona.personaapi.business;


import com.demo.persona.personaapi.dao.PersonaDao;
import com.demo.persona.personaapi.entity.Persona;
import com.demo.persona.personaapi.exception.DuplicateKeyException;
import com.demo.persona.personaapi.exception.InvalidFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class PersonaBusiness {

    @Autowired
    private PersonaDao personaDao;


    public List<Persona> listar() {		
		return personaDao.listar();
	}

	public Persona crear(Persona persona) throws DuplicateKeyException, InvalidFieldException {		
		try {
			validarCrear(persona);
		
			return personaDao.crear(persona);
			
		} catch (InvalidFieldException e) {
			throw new InvalidFieldException("Verificar los datos de la persona > " + e.getMessage());
		}
	}

	private void validarCrear(Persona persona) throws InvalidFieldException {
	
		if(persona.getEmail() == null  || persona.getEmail().trim().isEmpty()) {
			throw new InvalidFieldException("El campo Email es obligatorio");
		}
		
		if(persona.getNombre() == null  || persona.getNombre().trim().isEmpty()) {
			throw new InvalidFieldException("El campo Nombre es obligatorio");
		}
		
		if(persona.getApellido() == null  || persona.getApellido().trim().isEmpty()) {
			throw new InvalidFieldException("El campo Apellido es obligatorio");
		}
		
		if(persona.getEdad() == null || persona.getEdad().intValue() < 0 || persona.getEdad().intValue() > 120) {
			throw new InvalidFieldException("El campo Edad es obligatorio y debe ser mayor a 0 y menor 121");
		}
		
		if(persona.getAltura() == null || persona.getAltura().doubleValue() < 0 || persona.getAltura().doubleValue() > 3) {
			throw new InvalidFieldException("El campo Altura es obligatorio y debe ser mayor a 0 y menor 3");
		}
	}
		

	public void borrar(Integer id) throws NoSuchElementException, InvalidFieldException {
		try {
			validarBorrar(id);
		
			personaDao.borrar(id);
			
		} catch (InvalidFieldException e) {
			throw new InvalidFieldException("Verificar los datos de la persona > " + e.getMessage());
		}
	}

	private void validarBorrar(Integer id) throws InvalidFieldException {
		if(id == null || id < 1) {
			throw new InvalidFieldException("El campo Id es obligatorio y debe ser mayor a 0");
		}
	}

	public void modificar(Integer id, Persona persona) throws NoSuchElementException, InvalidFieldException {
		try {
			validarModificar(id, persona);
		
			persona.setId(id);
			
			personaDao.modificar(persona);
			
		} catch (InvalidFieldException e) {
			throw new InvalidFieldException("Verificar los datos de la persona > " + e.getMessage());
		}
	}

	private void validarModificar(Integer id, Persona persona) throws InvalidFieldException {
		if(id == null || id < 1) {
			throw new InvalidFieldException("El campo Id es obligatorio y debe ser mayor a 0");
		}
		
		if(persona.getEmail() == null  || persona.getEmail().trim().isEmpty()) {
			throw new InvalidFieldException("El campo Email es obligatorio");
		}
		
		if(persona.getNombre() == null  || persona.getNombre().trim().isEmpty()) {
			throw new InvalidFieldException("El campo Nombre es obligatorio");
		}
		
		if(persona.getApellido() == null  || persona.getApellido().trim().isEmpty()) {
			throw new InvalidFieldException("El campo Apellido es obligatorio");
		}
		
		if(persona.getEdad() == null || persona.getEdad().intValue() < 0 || persona.getEdad().intValue() > 120) {
			throw new InvalidFieldException("El campo Edad es obligatorio y debe ser mayor a 0 y menor 121");
		}
		
		if(persona.getAltura() == null || persona.getAltura().doubleValue() < 0 || persona.getAltura().doubleValue() > 3) {
			throw new InvalidFieldException("El campo Altura es obligatorio y debe ser mayor a 0 y menor 3");
		}
	}
    
}

package com.demo.pelicula.peliculaapi.business;

import com.demo.pelicula.peliculaapi.dao.PeliculaDao;
import com.demo.pelicula.peliculaapi.entity.Pelicula;
import com.demo.pelicula.peliculaapi.exception.DuplicateKeyException;
import com.demo.pelicula.peliculaapi.exception.InvalidFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class PeliculaBusiness {

    @Autowired
    private PeliculaDao peliculaDao;


    public List<Pelicula> listar() {		
		return peliculaDao.listar();
	}

	public Pelicula crear(Pelicula pelicula) throws DuplicateKeyException, InvalidFieldException {		
		try {
			validarCrear(pelicula);
		
			return peliculaDao.crear(pelicula);
			
		} catch (InvalidFieldException e) {
			throw new InvalidFieldException("Verificar los datos de la pelicula > " + e.getMessage());
		}
	}

	private void validarCrear(Pelicula pelicula) throws InvalidFieldException {
	
		if(pelicula.getDirector() == null  || pelicula.getDirector().trim().isEmpty()) {
			throw new InvalidFieldException("El campo Director es obligatorio");
		}
		
		if(pelicula.getNombre() == null  || pelicula.getNombre().trim().isEmpty()) {
			throw new InvalidFieldException("El campo Nombre es obligatorio");
		}
		
		if(pelicula.getGenero() == null  || pelicula.getGenero().trim().isEmpty()) {
			throw new InvalidFieldException("El campo Genero es obligatorio");
		}
		
	}
		

	public void borrar(Integer id) throws NoSuchElementException, InvalidFieldException {
		try {
			validarBorrar(id);
		
			peliculaDao.borrar(id);
			
		} catch (InvalidFieldException e) {
			throw new InvalidFieldException("Verificar los datos de la pelicula > " + e.getMessage());
		}
	}

	private void validarBorrar(Integer id) throws InvalidFieldException {
		if(id == null || id < 1) {
			throw new InvalidFieldException("El campo Id es obligatorio y debe ser mayor a 0");
		}
	}

	public void modificar(Integer id, Pelicula persona) throws NoSuchElementException, InvalidFieldException {
		try {
			validarModificar(id, persona);
		
			persona.setId(id);
			
			peliculaDao.modificar(persona);
			
		} catch (InvalidFieldException e) {
			throw new InvalidFieldException("Verificar los datos de la pelicula > " + e.getMessage());
		}
	}

	private void validarModificar(Integer id, Pelicula pelicula) throws InvalidFieldException {
		if(id == null || id < 1) {
			throw new InvalidFieldException("El campo Id es obligatorio y debe ser mayor a 0");
		}
		
		validarCrear(pelicula);
	}
    
}

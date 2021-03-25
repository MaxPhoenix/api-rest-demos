package com.demo.club.clubapi.business;

import com.demo.club.clubapi.dao.ClubDao;
import com.demo.club.clubapi.entity.Club;
import com.demo.club.clubapi.exception.DuplicateKeyException;
import com.demo.club.clubapi.exception.InvalidFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ClubBusiness {

    @Autowired
    private ClubDao clubDao;


    public List<Club> listar() {		
		return clubDao.listar();
	}

	public Club crear(Club club) throws DuplicateKeyException, InvalidFieldException {		
		try {
			validarCrear(club);
		
			return clubDao.crear(club);
			
		} catch (InvalidFieldException e) {
			throw new InvalidFieldException("Verificar los datos del Club > " + e.getMessage());
		}
	}

	private void validarCrear(Club club) throws InvalidFieldException {
	
		if(club.getCategoria() == null  || club.getCategoria() == 0) {
			throw new InvalidFieldException("El campo Categoria es obligatorio");
		}
		
		if(club.getNombre() == null  || club.getNombre().trim().isEmpty()) {
			throw new InvalidFieldException("El campo Nombre es obligatorio");
		}
	}
		

	public void borrar(Integer id) throws NoSuchElementException, InvalidFieldException {
		try {
			validarBorrar(id);
		
			clubDao.borrar(id);
			
		} catch (InvalidFieldException e) {
			throw new InvalidFieldException("Verificar los datos del Club > " + e.getMessage());
		}
	}

	private void validarBorrar(Integer id) throws InvalidFieldException {
		if(id == null || id < 1) {
			throw new InvalidFieldException("El campo Id es obligatorio y debe ser mayor a 0");
		}
	}

	public void modificar(Integer id, Club persona) throws NoSuchElementException, InvalidFieldException {
		try {
			validarModificar(id, persona);
		
			persona.setId(id);
			
			clubDao.modificar(persona);
			
		} catch (InvalidFieldException e) {
			throw new InvalidFieldException("Verificar los datos del Club > " + e.getMessage());
		}
	}

	private void validarModificar(Integer id, Club pelicula) throws InvalidFieldException {
		if(id == null || id < 1) {
			throw new InvalidFieldException("El campo Id es obligatorio y debe ser mayor a 0");
		}
		
		validarCrear(pelicula);
	}
    
}

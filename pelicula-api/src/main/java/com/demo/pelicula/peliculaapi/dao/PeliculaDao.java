package com.demo.pelicula.peliculaapi.dao;


import com.demo.pelicula.peliculaapi.entity.Pelicula;
import com.demo.pelicula.peliculaapi.exception.DuplicateKeyException;
import com.demo.pelicula.peliculaapi.mock.PeliculaMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class PeliculaDao {
    
    @Autowired
    private PeliculaMock peliculaMock;

    public List<Pelicula> listar() {
		
		return peliculaMock.listar();
	}

	public Pelicula crear(Pelicula pelicula) throws DuplicateKeyException {
		try {
			return peliculaMock.crear(pelicula);
		} 
		catch (DuplicateKeyException e) {
			throw new DuplicateKeyException("Ya existe una persona con ese email y/o ID");
		}
	}

	public void borrar(Integer id) throws NoSuchElementException {
		try {
			peliculaMock.borrar(id);
		} 
		catch (NoSuchElementException e) {
			throw new NoSuchElementException("La persona a Borrar no existe");
		}
	}

	public void modificar(Pelicula pelicula) throws NoSuchElementException {
		try {
			peliculaMock.modificar(pelicula);
		} 
		catch (NoSuchElementException e) {
			throw new NoSuchElementException("La persona a Modificar no existe");
		}
	}
}

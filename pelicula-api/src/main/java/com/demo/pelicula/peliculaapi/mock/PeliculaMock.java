package com.demo.pelicula.peliculaapi.mock;

import com.demo.pelicula.peliculaapi.entity.Pelicula;
import com.demo.pelicula.peliculaapi.exception.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class PeliculaMock {
	private List<Pelicula> datos;
	private int id;
		
	public PeliculaMock() {
		datos = new ArrayList<>();
		id = 1;
	}
	
	public List<Pelicula> listar() {
		return datos;
	}

	public Pelicula crear(Pelicula dato) throws DuplicateKeyException {
		if(registroYaExiste(dato)) {
			throw new DuplicateKeyException();
		}
		else {
			dato.setId(id);
			datos.add(dato);
			id++;
			
			return dato;
		}
	}
	
	private boolean registroYaExiste(Pelicula dato) {
		return buscarPorId(dato.getId()) != null || buscarPorNombre(dato.getNombre()) != null;
	}
	
	public Pelicula buscarPorNombre(String nombre) {
		Pelicula dato = null;
		
		for (int i = 0; i < datos.size(); i++) {
			if(datos.get(i).getNombre().compareToIgnoreCase(nombre) == 0) {
				dato = datos.get(i);
			}				
		}
		
		return dato;
	}

	public void borrar(Integer id) {
		Pelicula dato = buscarPorId(id);
		
		if(dato != null) {
			datos.remove(dato);			
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	public Pelicula buscarPorId(Integer id) {
		for (int i = 0; datos != null && i < datos.size(); i++) {
			if(datos.get(i).getId().equals(id)) {
				return datos.get(i);
			}				
		}
				
		return null;
	}

	public void modificar(Pelicula dato) {
		boolean registroModificado = false;
		for (int i = 0; !registroModificado && i < datos.size(); i++) {
			registroModificado = datos.get(i).getId().equals(dato.getId());			
			if(registroModificado) {
				datos.set(i, dato);
			}				
		}
		
		if(!registroModificado) {
			throw new NoSuchElementException();
		}
	}

	public Pelicula listarPorId(Integer id) {
		Pelicula persona = null;
		
		for (int i = 0; i < datos.size(); i++) {
			if(datos.get(i).getId().equals(id)) {
				persona = datos.get(i);
			}				
		}
		
		return persona;
	}

}
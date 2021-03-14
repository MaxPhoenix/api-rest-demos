package com.demo.pelicula.peliculaapi.mock;

import com.demo.pelicula.peliculaapi.entity.Pelicula;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PeliculaMock {
	private List<Pelicula> peliculaMock;
	private int id;
		
	public PeliculaMock() {
		peliculaMock = new ArrayList<>();
		id = 1;
	}
	
	public List<Pelicula> listar() {
		return peliculaMock;
	}

	public Pelicula crear(Pelicula pelicula) throws Exception {
		if(buscarPorId(pelicula.getId()) != null) {
			System.out.println("Esa pelicula ya existe");
			throw new Exception("Registro ya existente.");
		}
		else {
			pelicula.setId(id);
			peliculaMock.add(pelicula);
			id++;			
		}
		return pelicula;		
	}

	public boolean borrar(Integer id) {
		Pelicula pelicula = buscarPorId(id);
		
		if(pelicula != null) {
			peliculaMock.remove(pelicula);			
		}
		else {
			System.out.println("Pelicula no encontrada");
		}
		
		return pelicula != null;
	}
	
	public Pelicula buscarPorId(Integer id) {
		for (int i = 0; peliculaMock != null && i < peliculaMock.size(); i++) {
			if(peliculaMock.get(i).getId().equals(id)) {
				return peliculaMock.get(i);
			}				
		}
				
		return null;
	}

	public void modificar(Pelicula pelicula) {
		boolean registroModificado = false;
		for (int i = 0; !registroModificado && i < peliculaMock.size(); i++) {
			registroModificado = peliculaMock.get(i).getId().equals(pelicula.getId());			
			if(registroModificado) {
				peliculaMock.set(i, pelicula);
			}				
		}
		
		if(!registroModificado) {
			System.out.println("Pelicula no encontrada");
		}
	}

	public Pelicula listarPorId(Integer id) {
		Pelicula pelicula = null;
		
		for (int i = 0; i < peliculaMock.size(); i++) {
			if(peliculaMock.get(i).getId().equals(id)) {
				pelicula = peliculaMock.get(i);
			}				
		}
		
		return pelicula;
	}

}
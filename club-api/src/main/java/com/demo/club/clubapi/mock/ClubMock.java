package com.demo.club.clubapi.mock;

import com.demo.club.clubapi.entity.Club;
import com.demo.club.clubapi.exception.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ClubMock {
	private List<Club> datos;
	private int id;
	
	public ClubMock() {
		datos = new ArrayList<>();
		id = 1;
	}
		
	public List<Club> listar() {
		return datos;
	}

	public Club crear(Club dato) throws DuplicateKeyException {
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
	
	private boolean registroYaExiste(Club dato) {
		return buscarPorId(dato.getId()) != null || buscarPorNombre(dato.getNombre()) != null;
	}
	
	public Club buscarPorNombre(String email) {
		Club dato = null;
		
		for (int i = 0; i < datos.size(); i++) {
			if(datos.get(i).getNombre().compareToIgnoreCase(email) == 0) {
				dato = datos.get(i);
			}				
		}
		
		return dato;
	}

	public void borrar(Integer id) {
		Club dato = buscarPorId(id);
		
		if(dato != null) {
			datos.remove(dato);			
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	public Club buscarPorId(Integer id) {
		for (int i = 0; datos != null && i < datos.size(); i++) {
			if(datos.get(i).getId().equals(id)) {
				return datos.get(i);
			}				
		}
				
		return null;
	}

	public void modificar(Club dato) {
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

	public Club listarPorId(Integer id) {
		Club persona = null;
		
		for (int i = 0; i < datos.size(); i++) {
			if(datos.get(i).getId().equals(id)) {
				persona = datos.get(i);
			}				
		}
		
		return persona;
	}
	
}

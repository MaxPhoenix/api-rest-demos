package com.demo.club.clubapi.mock;

import com.demo.club.clubapi.entity.Club;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClubMock {
	private List<Club> clubMock;
	private int id;
	
	public ClubMock() {
		clubMock = new ArrayList<>();
		id = 1;
	}
		
	public Club crear(Club club) throws Exception {
		if(buscarPorId(club.getId()) != null) {
			System.out.println("Esa club ya existe");
			throw new Exception("Registro ya existente.");
		}
		else {
			club.setId(id);
			clubMock.add(club);
			id++;
		}
		return club;		
	}
	
	public List<Club> listar() {
		return clubMock;
	}

	public void modificar(Club club) {
		boolean registroModificado = false;
		for (int i = 0; !registroModificado && i < clubMock.size(); i++) {
			registroModificado = clubMock.get(i).getId().equals(club.getId());			
			if(registroModificado) {
				
				if(club.getNombre() != null && !club.getNombre().trim().isEmpty()) {
					clubMock.get(i).setNombre(club.getNombre());					
				}
				
				if(club.getCategoria() != null) {
					clubMock.get(i).setCategoria(club.getCategoria());	
				}								
			}				
		}
		
		if(!registroModificado) {
			System.out.println("club no encontrado");
		}
	}

	public boolean borrar(Integer id) {
		Club club = buscarPorId(id);
		
		if(club != null) {
			clubMock.remove(club);			
		}
		else {
			System.out.println("club no encontrado");
		}
		
		return club != null;
	}
	
	public Club buscarPorId(Integer id) {
		for (int i = 0; clubMock != null && i < clubMock.size(); i++) {
			if(clubMock.get(i).getId().equals(id)) {
				return clubMock.get(i);
			}				
		}
				
		return null;
	}
	
}

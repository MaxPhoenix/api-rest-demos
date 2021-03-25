package com.demo.club.clubapi.dao;

import com.demo.club.clubapi.entity.Club;
import com.demo.club.clubapi.exception.DuplicateKeyException;
import com.demo.club.clubapi.mock.ClubMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ClubDao {
    
    @Autowired
    private ClubMock clubMock;

    public List<Club> listar() {
		
		return clubMock.listar();
	}

	public Club crear(Club club) throws DuplicateKeyException {
		try {
			return clubMock.crear(club);
		} 
		catch (DuplicateKeyException e) {
			throw new DuplicateKeyException("Ya existe una persona con ese email y/o ID");
		}
	}

	public void borrar(Integer id) throws NoSuchElementException {
		try {
			clubMock.borrar(id);
		} 
		catch (NoSuchElementException e) {
			throw new NoSuchElementException("La persona a Borrar no existe");
		}
	}

	public void modificar(Club club) throws NoSuchElementException {
		try {
			clubMock.modificar(club);
		} 
		catch (NoSuchElementException e) {
			throw new NoSuchElementException("La persona a Modificar no existe");
		}
	}
}

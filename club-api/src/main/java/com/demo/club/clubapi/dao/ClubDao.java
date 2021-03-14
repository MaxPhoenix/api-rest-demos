package com.demo.club.clubapi.dao;

import com.demo.club.clubapi.entity.Club;
import com.demo.club.clubapi.mock.ClubMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubDao {
    
    @Autowired
    private ClubMock clubMock;

    public List<Club> listar() {
        return this.clubMock.listar();
    }

    public Club buscarPorId(Integer id) {
        return this.clubMock.buscarPorId(id);
    }

    public Club crear(Club club) throws Exception {
        return this.clubMock.crear(club);
    }

    public void modificar(Club club) {
        this.clubMock.modificar(club);
    }

    public void eliminar(Integer id) {
        this.clubMock.borrar(id);
    }
}

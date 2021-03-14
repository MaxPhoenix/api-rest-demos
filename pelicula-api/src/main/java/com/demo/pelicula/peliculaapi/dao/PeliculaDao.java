package com.demo.pelicula.peliculaapi.dao;


import com.demo.pelicula.peliculaapi.entity.Pelicula;
import com.demo.pelicula.peliculaapi.mock.PeliculaMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeliculaDao {
    
    @Autowired
    private PeliculaMock clubMock;

    public List<Pelicula> listar() {
        return this.clubMock.listar();
    }

    public Pelicula buscarPorId(Integer id) {
        return this.clubMock.buscarPorId(id);
    }

    public Pelicula crear(Pelicula club) throws Exception {
        return this.clubMock.crear(club);
    }

    public void modificar(Pelicula club) {
        this.clubMock.modificar(club);
    }

    public void eliminar(Integer id) {
        this.clubMock.borrar(id);
    }
}

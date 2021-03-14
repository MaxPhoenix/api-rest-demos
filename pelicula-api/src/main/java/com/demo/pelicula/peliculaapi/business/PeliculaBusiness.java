package com.demo.pelicula.peliculaapi.business;

import com.demo.pelicula.peliculaapi.dao.PeliculaDao;
import com.demo.pelicula.peliculaapi.entity.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PeliculaBusiness {

    @Autowired
    private PeliculaDao peliculaDao;


    public List<Pelicula> listar() {
       return  this.peliculaDao.listar();
    }

    public Pelicula crear(Pelicula club) throws Exception {
        return this.peliculaDao.crear(club);
    }

    public void modificar(Integer id, Pelicula club) {
        club.setId(id);
        this.peliculaDao.modificar(club);
    }

    public void eliminar(Integer id) {
        this.peliculaDao.eliminar(id);
    }
    
}

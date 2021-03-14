package com.demo.pelicula.peliculaapi.controller;

import com.demo.pelicula.peliculaapi.business.PeliculaBusiness;
import com.demo.pelicula.peliculaapi.entity.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v0/peliculas")
public class PeliculaController {
    
    @Autowired
    private PeliculaBusiness peliculaBusiness;

    @GetMapping(value="")
    public List<Pelicula> listar() {
        return this.peliculaBusiness.listar();
    }

    @PostMapping(value="")
    public Pelicula crear(@RequestBody Pelicula clubDto) throws Exception {
        return this.peliculaBusiness.crear(clubDto);
    }
    
    @PutMapping(value="/{id}")
    public void modificar(@PathVariable Integer id, @RequestBody Pelicula clubDto) {
        this.peliculaBusiness.modificar(id, clubDto);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Integer id) {
        this.peliculaBusiness.eliminar(id);
    }


}

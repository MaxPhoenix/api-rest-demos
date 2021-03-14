package com.demo.persona.personaapi.controller;


import com.demo.persona.personaapi.business.PersonaBusiness;
import com.demo.persona.personaapi.entity.Persona;
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
@RequestMapping("/v0/personas")
public class PersonaController {
    
    @Autowired
    private PersonaBusiness personaBusiness;

    @GetMapping(value="")
    public List<Persona> listar() {
        return this.personaBusiness.listar();
    }

    @PostMapping(value="")
    public Persona crear(@RequestBody Persona clubDto) throws Exception {
        return this.personaBusiness.crear(clubDto);
    }
    
    @PutMapping(value="/{id}")
    public void modificar(@PathVariable Integer id, @RequestBody Persona clubDto) {
        this.personaBusiness.modificar(id, clubDto);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Integer id) {
        this.personaBusiness.eliminar(id);
    }


}
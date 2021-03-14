package com.demo.persona.personaapi.business;


import com.demo.persona.personaapi.dao.PersonaDao;
import com.demo.persona.personaapi.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonaBusiness {

    @Autowired
    private PersonaDao personaDao;


    public List<Persona> listar() {
       return  this.personaDao.listar();
    }

    public Persona crear(Persona club) throws Exception {
        return this.personaDao.crear(club);
    }

    public void modificar(Integer id, Persona club) {
        club.setId(id);
        this.personaDao.modificar(club);
    }

    public void eliminar(Integer id) {
        this.personaDao.eliminar(id);
    }
    
}

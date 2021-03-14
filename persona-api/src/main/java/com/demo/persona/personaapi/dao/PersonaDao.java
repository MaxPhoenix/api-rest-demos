package com.demo.persona.personaapi.dao;

import com.demo.persona.personaapi.entity.Persona;
import com.demo.persona.personaapi.mock.PersonaMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaDao {
    
    @Autowired
    private PersonaMock personaMock;

    public List<Persona> listar() {
        return this.personaMock.listar();
    }

    public Persona buscarPorId(Integer id) {
        return this.personaMock.buscarPorId(id);
    }

    public Persona crear(Persona club) throws Exception {
        return this.personaMock.crear(club);
    }

    public void modificar(Persona club) {
        this.personaMock.modificar(club);
    }

    public void eliminar(Integer id) {
        this.personaMock.borrar(id);
    }
}

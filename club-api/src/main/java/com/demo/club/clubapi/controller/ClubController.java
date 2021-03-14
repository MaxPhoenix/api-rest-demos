package com.demo.club.clubapi.controller;

import com.demo.club.clubapi.business.ClubBusiness;
import com.demo.club.clubapi.entity.Club;
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
@RequestMapping("/v0/clubs")
public class ClubController {
    
    @Autowired
    private ClubBusiness clubBusiness;

    @GetMapping(value="")
    public List<Club> listar() {
        return this.clubBusiness.listar();
    }

    @PostMapping(value="")
    public Club crear(@RequestBody Club clubDto) throws Exception {
        return this.clubBusiness.crear(clubDto);
    }
    
    @PutMapping(value="/{id}")
    public void modificar(@PathVariable Integer id, @RequestBody Club clubDto) {
        this.clubBusiness.modificar(id, clubDto);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Integer id) {
        this.clubBusiness.eliminar(id);
    }


}

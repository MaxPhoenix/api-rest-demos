package com.demo.club.clubapi.business;

import com.demo.club.clubapi.dao.ClubDao;
import com.demo.club.clubapi.entity.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClubBusiness {

    @Autowired
    private ClubDao clubDao;


    public List<Club> listar() {
       return  this.clubDao.listar();
    }

    public Club crear(Club club) throws Exception {
        return this.clubDao.crear(club);
    }

    public void modificar(Integer id, Club club) {
        club.setId(id);
        this.clubDao.modificar(club);
    }

    public void eliminar(Integer id) {
        this.clubDao.eliminar(id);
    }
    
}

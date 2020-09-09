package com.service;

import com.model.Maden;

import java.util.List;

public interface IMadenService {
    List<Maden> listMaden();

    Maden getMadenById(Integer id);

    Maden savemaden(Maden maden);

    //Maden updatemaden(Maden maden);

    void deletemaden(Integer id);

}

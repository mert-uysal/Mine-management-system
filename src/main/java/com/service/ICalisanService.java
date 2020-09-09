package com.service;

import com.model.Calisan;

import java.util.List;

public interface ICalisanService {
    List<Calisan> listAllCalisan();

    Calisan getCalisanById(Integer id);

    Calisan savecalisan(Calisan calisan);

    void deletecalisan(Integer id);
}

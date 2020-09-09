package com.service;

import com.model.Maden;
import com.repository.MadenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MadenServiceImpl implements IMadenService {

    private final MadenRepository madenRepository;

    @Autowired
    public MadenServiceImpl(MadenRepository madenRepository) {
        this.madenRepository = madenRepository;
    }

    @Override
    public List<Maden> listMaden() {
        return madenRepository.findAll();
    }

    @Override
    public Maden getMadenById(Integer id) {
        return madenRepository.findById(id).orElse(null);
    }

    @Override
    public Maden savemaden(Maden maden) {
        madenRepository.save(maden);
        return maden;
    }

    @Override
    public void deletemaden(Integer id) {
        madenRepository.deleteById(id);
    }

   /* @Override
    public Maden updatemaden(Maden maden) {
        Maden existingMaden = madenRepository.findById((int) maden.getId()).orElse(null);
        assert existingMaden != null;
        existingMaden.setMaden_adi(maden.getMaden_adi());
        return madenRepository.save(existingMaden);
    }*/
}

package com.service;

import com.model.Calisan;
import com.repository.CalisanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalisanServiceImpl implements ICalisanService {

    private final CalisanRepository calisanRepository;

    @Autowired
    public CalisanServiceImpl(CalisanRepository calisanRepository) {
        this.calisanRepository = calisanRepository;
    }

    @Override
    public List<Calisan> listAllCalisan() {
        return calisanRepository.findAll();
    }

    @Override
    public Calisan getCalisanById(Integer id) {
        return calisanRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Calisan Id:" + id));
    }

    @Override
    public Calisan savecalisan(Calisan calisan) {
        calisanRepository.save(calisan);
        return calisan;
    }

    @Override
    public void deletecalisan(Integer id) {
        calisanRepository.deleteById(id);
    }
}

/*@Override
    public Calisan savecalisan(Calisan calisan) {
        if (calisan.getId() == null) {
            calisan = calisanRepository.save(calisan);
            return calisan;
        } else {
            Optional<Calisan> calisan1 = calisanRepository.findById(calisan.getId());
            if (calisan1.isPresent()) {
                Calisan newCalisan = calisan1.get();
                newCalisan.setCalisanAdi(calisan.getCalisanAdi());
                newCalisan.setCalisanSoyad(calisan.getCalisanSoyad());
                newCalisan.setMadenler(calisan.getMadenler());

                newCalisan = calisanRepository.save(newCalisan);

                return newCalisan;
            } else {
                calisan = calisanRepository.save(calisan);

                return calisan;
            }
        }
    }*/
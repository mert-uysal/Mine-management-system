package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Maden {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "proje1_auto_incre_seq"
    )
    @SequenceGenerator(
            name = "proje1_auto_incre_seq",
            allocationSize = 1
    )
    private Integer id;

    private String madenAdi;

    private String madenCinsi;

    @ManyToMany(mappedBy = "madenler")
    private Set<Calisan> calisanlar = new HashSet<>();

    public Maden() {

    }

    public Maden(Integer id, String madenAdi, String madenCinsi, Set<Calisan> calisanlar) {
        this.id = id;
        this.madenAdi = madenAdi;
        this.madenCinsi = madenCinsi;
        this.calisanlar = calisanlar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMadenAdi() {
        return madenAdi;
    }

    public void setMadenAdi(String madenAdi) {
        this.madenAdi = madenAdi;
    }

    public String getMadenCinsi() {
        return madenCinsi;
    }

    public void setMadenCinsi(String madenCinsi) {
        this.madenCinsi = madenCinsi;
    }

    public Set<Calisan> getCalisanlar() {
        return calisanlar;
    }

    public void setCalisanlar(Set<Calisan> calisanlar) {
        this.calisanlar = calisanlar;
    }
}

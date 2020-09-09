package com.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Calisan {

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

    private String calisanAdi;
    private String calisanSoyad;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "calisma_tablosu", joinColumns = @JoinColumn(name = "calisan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "maden_id", referencedColumnName = "id"))
    Set<Maden> madenler = new HashSet<>();

    public Calisan(Integer id, String calisanAdi, String calisanSoyad, Set<Maden> madenler) {
        this.id = id;
        this.calisanAdi = calisanAdi;
        this.calisanSoyad = calisanSoyad;
        this.madenler = madenler;
    }

    public Calisan() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalisanAdi() {
        return calisanAdi;
    }

    public void setCalisanAdi(String calisanAdi) {
        this.calisanAdi = calisanAdi;
    }

    public String getCalisanSoyad() {
        return calisanSoyad;
    }

    public void setCalisanSoyad(String calisanSoyad) {
        this.calisanSoyad = calisanSoyad;
    }


    public Set<Maden> getMadenler() {
        return madenler;
    }

    public void setMadenler(Set<Maden> madenler) {
        this.madenler = madenler;
    }

}

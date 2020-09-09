package com.repository;

import com.model.Calisan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalisanRepository extends JpaRepository<Calisan, Integer> {
}

package com.repository;

import com.model.Maden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MadenRepository extends JpaRepository<Maden, Integer> {
}

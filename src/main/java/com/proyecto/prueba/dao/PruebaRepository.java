package com.proyecto.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.prueba.dto.Prueba;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long>{
}

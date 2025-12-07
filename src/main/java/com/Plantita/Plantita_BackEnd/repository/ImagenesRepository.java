package com.Plantita.Plantita_BackEnd.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Plantita.Plantita_BackEnd.model.Imagenes;

@Repository
public interface ImagenesRepository extends JpaRepository<Imagenes, Integer> {
    
}

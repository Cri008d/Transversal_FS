package com.Plantita.Plantita_BackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Plantita.Plantita_BackEnd.model.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer>{

    List<Color> findByCodigo(String codigo);

    List<Color> findByNombre(String nombre);
    
}

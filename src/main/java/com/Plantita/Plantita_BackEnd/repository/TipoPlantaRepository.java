package com.Plantita.Plantita_BackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Plantita.Plantita_BackEnd.model.TipoPlanta;
import java.util.List;

@Repository
public interface TipoPlantaRepository extends JpaRepository<TipoPlanta, Integer>{
    
    List<TipoPlanta> findByNombre(String nombre);
}

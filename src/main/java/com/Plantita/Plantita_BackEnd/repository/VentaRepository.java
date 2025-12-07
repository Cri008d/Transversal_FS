package com.Plantita.Plantita_BackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Plantita.Plantita_BackEnd.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

    List<Venta> findByIdVenta(Integer idVenta);
    
}

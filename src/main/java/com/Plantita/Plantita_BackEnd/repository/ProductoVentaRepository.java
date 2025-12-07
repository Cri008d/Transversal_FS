package com.Plantita.Plantita_BackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Plantita.Plantita_BackEnd.model.ProductoVenta;

@Repository
public interface ProductoVentaRepository extends JpaRepository<ProductoVenta, Integer>{
    
}

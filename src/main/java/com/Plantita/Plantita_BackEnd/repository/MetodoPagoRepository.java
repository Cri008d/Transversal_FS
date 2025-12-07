package com.Plantita.Plantita_BackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Plantita.Plantita_BackEnd.model.MetodoPago;

@Repository
public interface MetodoPagoRepository extends JpaRepository <MetodoPago, Long>{

    List<MetodoPago> findByNomMetPago(String nomMetPago); // Chicos, aqui usamos List porque puede haber varios registros en la base de datos que tengan el mismo "nombreMetodo"
}
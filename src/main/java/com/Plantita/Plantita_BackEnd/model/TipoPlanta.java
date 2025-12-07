package com.Plantita.Plantita_BackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipoPlanta")
public class TipoPlanta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPlanta;

    @Column(length = 50, nullable = false)
    private String nombre;



}

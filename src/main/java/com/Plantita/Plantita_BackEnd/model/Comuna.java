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
@Table(name = "comuna")
public class Comuna {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComuna;

    @Column(length = 40, nullable = false)
    private String nomComuna;

}

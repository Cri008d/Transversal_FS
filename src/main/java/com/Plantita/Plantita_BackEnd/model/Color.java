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
@Table(name = "color")
public class Color {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idColor;

    @Column(length = 40, nullable = false)
    private String nombre;

    @Column(length = 40, nullable = false)
    private String codigo;

}

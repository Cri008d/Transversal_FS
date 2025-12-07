package com.Plantita.Plantita_BackEnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data  
@AllArgsConstructor 
@NoArgsConstructor  
@Table(name = "tiposPlanta")
public class TiposPlanta {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relacion_planta")
    private Integer idRelacion;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    @JsonBackReference
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idTipoPlanta", nullable = false)
    @JsonBackReference
    private TipoPlanta tipoPlanta;

}

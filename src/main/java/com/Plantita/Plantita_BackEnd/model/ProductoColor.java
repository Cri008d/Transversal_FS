package com.Plantita.Plantita_BackEnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "productoColor")
public class ProductoColor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProductoColor;

    //Producto id

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    @JsonBackReference
    private Producto producto;
    
    //Color id

    @ManyToOne
    @JoinColumn(name = "idColor", nullable = false)
    @JsonBackReference
    private Color color;
    
    



}

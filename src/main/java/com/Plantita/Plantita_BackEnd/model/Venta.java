package com.Plantita.Plantita_BackEnd.model;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Integer precioProd;

    @Column(nullable = false)
    private LocalDate fechaHora;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idEstado", nullable = false)
    @JsonBackReference
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "idMetodoEnvio", nullable = false)
    @JsonBackReference
    private MetodoEnvio metodoEnvio;

    @ManyToOne
    @JoinColumn(name = "idMetPago", nullable = false)
    @JsonBackReference
    private MetodoPago metodoPago;
    
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    @JsonBackReference
    private Direcciones direcciones;
}


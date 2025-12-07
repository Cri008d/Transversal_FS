package com.Plantita.Plantita_BackEnd.model;


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
@Table(name = "productoVenta")
public class ProductoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProdVenta;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta venta;


}

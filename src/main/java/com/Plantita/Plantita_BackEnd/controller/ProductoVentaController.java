package com.Plantita.Plantita_BackEnd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Plantita.Plantita_BackEnd.model.ProductoVenta;
import com.Plantita.Plantita_BackEnd.service.ProductoVentaService;

@RestController
@RequestMapping("/api/v1/producto-venta")
public class ProductoVentaController {

    @Autowired
    private ProductoVentaService service;

    @GetMapping
    public ResponseEntity<List<ProductoVenta>> listar() {
        List<ProductoVenta> lista = service.obtenerTodos();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<ProductoVenta> crear(@RequestBody ProductoVenta productoVenta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(productoVenta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
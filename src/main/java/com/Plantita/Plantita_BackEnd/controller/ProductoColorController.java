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

import com.Plantita.Plantita_BackEnd.model.ProductoColor;
import com.Plantita.Plantita_BackEnd.service.ProductoColorService;

@RestController
@RequestMapping("/api/v1/producto-color")
public class ProductoColorController {

    @Autowired
    private ProductoColorService productoColorService;

    @GetMapping
    public ResponseEntity<List<ProductoColor>> listar() {
        List<ProductoColor> lista = productoColorService.obtenerTodos();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<ProductoColor> asignarColor(@RequestBody ProductoColor productoColor) {
        ProductoColor nuevo = productoColorService.guardar(productoColor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            productoColorService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
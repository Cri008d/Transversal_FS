package com.Plantita.Plantita_BackEnd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Plantita.Plantita_BackEnd.model.Venta;
import com.Plantita.Plantita_BackEnd.service.VentaService;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> obtenerTodos() {
        List<Venta> ventas = ventaService.obtenerTodos();
        if (ventas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerPorId(@PathVariable Integer id) {
        Venta venta = ventaService.obtenerPorId(id);
        return (venta != null) ? ResponseEntity.ok(venta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Venta> crear(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.guardar(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> reemplazar(@PathVariable Integer id, @RequestBody Venta venta) {
        Venta ventaAct = ventaService.actualizar(id, venta);
        return (ventaAct != null) ? ResponseEntity.ok(ventaAct) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            ventaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
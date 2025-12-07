package com.Plantita.Plantita_BackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Plantita.Plantita_BackEnd.model.Estado;
import com.Plantita.Plantita_BackEnd.service.EstadoService;

@RestController
@RequestMapping("/api/v1/estados")
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> obtenerTodos() {
        List<Estado> estados = estadoService.obtenerTodos();
        if (estados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> obtenerPorId(@PathVariable Integer id) {
        Estado estado = estadoService.obtenerPorId(id);
        if (estado != null) {
            return ResponseEntity.ok(estado);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Estado> crear(@RequestBody Estado estado) {
        Estado nuevoEstado = estadoService.guardar(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> reemplazar(@PathVariable Integer id, @RequestBody Estado estado) {
        Estado estadoAct = estadoService.actualizar(id, estado);
        if (estadoAct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadoAct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Estado> actualizarParcial(@PathVariable Integer id, @RequestBody Estado estado) {
        Estado estadoP = estadoService.actualizar(id, estado);
        if (estadoP != null){
            return ResponseEntity.ok(estadoP);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try{
            estadoService.eliminar(id);
            return ResponseEntity.noContent().build(); 
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}

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

import com.Plantita.Plantita_BackEnd.model.Direcciones;
import com.Plantita.Plantita_BackEnd.service.DireccionesService;

@RestController
@RequestMapping("/api/v1/direcciones")
public class DireccionesController {
    
    @Autowired
    private DireccionesService direccionesService;

    @GetMapping
    public ResponseEntity<List<Direcciones>> obtenerTodos() {
        List<Direcciones> direcciones = direccionesService.obtenerTodos();
        if (direcciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direcciones> obtenerPorId(@PathVariable Integer id) {
        Direcciones direccion = direccionesService.obtenerPorId(id);
        if (direccion != null) {
            return ResponseEntity.ok(direccion);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Direcciones> crear(@RequestBody Direcciones direccion) {
        Direcciones nuevaDireccion = direccionesService.guardar(direccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaDireccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direcciones> reemplazar(@PathVariable Integer id, @RequestBody Direcciones direccion) {
        Direcciones direccionAct = direccionesService.actualizar(id, direccion);
        if (direccionAct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(direccionAct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Direcciones> actualizarParcial(@PathVariable Integer id, @RequestBody Direcciones direccion) {
        Direcciones direccionP = direccionesService.actualizar(id, direccion);
        if (direccionP != null){
            return ResponseEntity.ok(direccionP);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try{
            direccionesService.eliminar(id);
            return ResponseEntity.noContent().build(); 
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}

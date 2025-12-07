package com.Plantita.Plantita_BackEnd.controller;

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

import com.Plantita.Plantita_BackEnd.model.Comuna;
import com.Plantita.Plantita_BackEnd.service.ComunaService;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comunas")
public class ComunaController {
    
    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<Comuna>> obtenerTodos() {
        List<Comuna> comunas = comunaService.obtenerTodos();
        if (comunas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comunas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> obtenerPorId(@PathVariable Integer id) {
        Comuna comuna = comunaService.obtenerPorId(id);
        if (comuna != null) {
            return ResponseEntity.ok(comuna);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Comuna> crear(@RequestBody Comuna comuna) {
        Comuna nuevaComuna = comunaService.guardar(comuna);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaComuna);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> reemplazar(@PathVariable Integer id, @RequestBody Comuna comuna) {
        Comuna comunaAct = comunaService.actualizar(id, comuna);
        if (comunaAct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comunaAct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Comuna> actualizarParcial(@PathVariable Integer id, @RequestBody Comuna comuna) {
        Comuna comunaP = comunaService.actualizar(id, comuna);
        if (comunaP != null){
            return ResponseEntity.ok(comunaP);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try{
            comunaService.eliminar(id);
            return ResponseEntity.noContent().build(); 
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}

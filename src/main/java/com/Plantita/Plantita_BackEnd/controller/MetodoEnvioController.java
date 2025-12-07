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

import com.Plantita.Plantita_BackEnd.model.MetodoEnvio;
import com.Plantita.Plantita_BackEnd.service.MetodoEnvioService;

@RestController
@RequestMapping("/api/v1/metodos-envio")
public class MetodoEnvioController {
    
    @Autowired
    private MetodoEnvioService metodoEnvioService;

    @GetMapping
    public ResponseEntity<List<MetodoEnvio>> obtenerTodos() {
        List<MetodoEnvio> metodosEnvio = metodoEnvioService.obtenerTodos();
        if (metodosEnvio.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodosEnvio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoEnvio> obtenerPorId(@PathVariable Integer id) {
        MetodoEnvio metodoEnvio = metodoEnvioService.obtenerPorId(id);
        if (metodoEnvio != null) {
            return ResponseEntity.ok(metodoEnvio);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MetodoEnvio> crear(@RequestBody MetodoEnvio metodoEnvio) {
        MetodoEnvio nuevoMetodoEnvio = metodoEnvioService.guardar(metodoEnvio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMetodoEnvio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoEnvio> reemplazar(@PathVariable Integer id, @RequestBody MetodoEnvio metodoEnvio) {
        MetodoEnvio metodoEnvioAct = metodoEnvioService.actualizar(id, metodoEnvio);
        if (metodoEnvioAct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metodoEnvioAct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MetodoEnvio> actualizarParcial(@PathVariable Integer id, @RequestBody MetodoEnvio metodoEnvio) {
        MetodoEnvio metodoEnvioP = metodoEnvioService.actualizar(id, metodoEnvio);
        if (metodoEnvioP != null){
            return ResponseEntity.ok(metodoEnvioP);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try{
            metodoEnvioService.eliminar(id);
            return ResponseEntity.noContent().build(); 
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}

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

import com.Plantita.Plantita_BackEnd.model.MetodoPago;
import com.Plantita.Plantita_BackEnd.service.MetodoPagoService;

@RestController
@RequestMapping("/api/v1/metodos-pago")
public class MetodoPagoController {
 
    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public ResponseEntity<List<MetodoPago>> obtenerTodos() {
        List<MetodoPago> metodosPago = metodoPagoService.obtenerTodos();
        if (metodosPago.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodosPago);
    }

    // Usamos Long para el ID
    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> obtenerPorId(@PathVariable Long id) {
        MetodoPago metodoPago = metodoPagoService.obtenerPorId(id);
        if (metodoPago != null) {
            return ResponseEntity.ok(metodoPago);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MetodoPago> crear(@RequestBody MetodoPago metodoPago) {
        MetodoPago nuevoMetodoPago = metodoPagoService.guardar(metodoPago);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMetodoPago);
    }

    // Usamos Long para el ID
    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> reemplazar(@PathVariable Long id, @RequestBody MetodoPago metodoPago) {
        MetodoPago metodoPagoAct = metodoPagoService.actualizar(id, metodoPago);
        if (metodoPagoAct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metodoPagoAct);
    }

    // Usamos Long para el ID
    @PatchMapping("/{id}")
    public ResponseEntity<MetodoPago> actualizarParcial(@PathVariable Long id, @RequestBody MetodoPago metodoPago) {
        MetodoPago metodoPagoP = metodoPagoService.actualizar(id, metodoPago);
        if (metodoPagoP != null){
            return ResponseEntity.ok(metodoPagoP);
        }
        return ResponseEntity.notFound().build();
    }

    // Usamos Long para el ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try{
            metodoPagoService.eliminar(id);
            return ResponseEntity.noContent().build(); 
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}

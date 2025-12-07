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

import com.Plantita.Plantita_BackEnd.model.TipoPlanta;
import com.Plantita.Plantita_BackEnd.service.TipoPlantaService;

@RestController
@RequestMapping("/api/v1/tipos-planta")
public class TipoPlantaController {

    @Autowired
    private TipoPlantaService tipoPlantaService;

    @GetMapping
    public ResponseEntity<List<TipoPlanta>> listar() {
        List<TipoPlanta> tipos = tipoPlantaService.obtenerTodos();
        if (tipos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPlanta> obtenerPorId(@PathVariable Integer id) {
        TipoPlanta tipo = tipoPlantaService.obtenerPorId(id);
        if (tipo != null) {
            return ResponseEntity.ok(tipo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoPlanta> crear(@RequestBody TipoPlanta tipoPlanta) {
        TipoPlanta nuevoTipo = tipoPlantaService.guardar(tipoPlanta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPlanta> reemplazar(@PathVariable Integer id, @RequestBody TipoPlanta tipoPlanta) {
        TipoPlanta tipoAct = tipoPlantaService.actualizar(id, tipoPlanta);
        if (tipoAct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoAct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            tipoPlantaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
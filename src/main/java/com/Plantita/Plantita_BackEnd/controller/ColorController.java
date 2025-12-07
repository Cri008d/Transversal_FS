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

import com.Plantita.Plantita_BackEnd.model.Color;
import com.Plantita.Plantita_BackEnd.service.ColorService;

@RestController
@RequestMapping("/api/v1/colores")
public class ColorController {
    
    @Autowired
    private ColorService colorService;

    @GetMapping
    public ResponseEntity<List<Color>> obtenerTodos() {
        List<Color> colores = colorService.obtenerTodos();
        if (colores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(colores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> obtenerPorId(@PathVariable Integer id) {
        Color color = colorService.obtenerPorId(id);
        if (color != null) {
            return ResponseEntity.ok(color);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Color> crear(@RequestBody Color color) {
        Color nuevoColor = colorService.guardar(color);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoColor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> reemplazar(@PathVariable Integer id, @RequestBody Color color) {
        Color colorAct = colorService.actualizar(id, color);
        if (colorAct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(colorAct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Color> actualizarParcial(@PathVariable Integer id, @RequestBody Color color) {
        Color colorP = colorService.actualizar(id, color);
        if (colorP != null){
            return ResponseEntity.ok(colorP);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try{
            colorService.eliminar(id);
            return ResponseEntity.noContent().build(); 
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}

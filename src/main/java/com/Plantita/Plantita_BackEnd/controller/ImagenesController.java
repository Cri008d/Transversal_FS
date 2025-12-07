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

import com.Plantita.Plantita_BackEnd.model.Imagenes;
import com.Plantita.Plantita_BackEnd.service.ImagenesService;

@RestController
@RequestMapping("/api/v1/imagenes")
public class ImagenesController {
    
    @Autowired
    private ImagenesService imagenesService;

    @GetMapping
    public ResponseEntity<List<Imagenes>> obtenerTodos() {
        List<Imagenes> imagenes = imagenesService.obtenerTodos();
        if (imagenes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(imagenes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagenes> obtenerPorId(@PathVariable Integer id) {
        Imagenes imagen = imagenesService.obtenerPorId(id);
        if (imagen != null) {
            return ResponseEntity.ok(imagen);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Imagenes> crear(@RequestBody Imagenes imagen) {
        Imagenes nuevaImagen = imagenesService.guardar(imagen);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaImagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagenes> reemplazar(@PathVariable Integer id, @RequestBody Imagenes imagen) {
        Imagenes imagenAct = imagenesService.actualizar(id, imagen);
        if (imagenAct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imagenAct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Imagenes> actualizarParcial(@PathVariable Integer id, @RequestBody Imagenes imagen) {
        Imagenes imagenP = imagenesService.actualizar(id, imagen);
        if (imagenP != null){
            return ResponseEntity.ok(imagenP);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try{
            imagenesService.eliminar(id);
            return ResponseEntity.noContent().build(); 
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}

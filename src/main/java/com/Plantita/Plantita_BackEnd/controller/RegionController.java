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

import com.Plantita.Plantita_BackEnd.model.Region;
import com.Plantita.Plantita_BackEnd.service.RegionService;

@RestController
@RequestMapping("/api/v1/regiones")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> obtenerTodos() {
        List<Region> regiones = regionService.obtenerTodos();
        if (regiones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regiones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> obtenerPorId(@PathVariable Integer id) {
        Region region = regionService.obtenerPorId(id);
        if (region != null) {
            return ResponseEntity.ok(region);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Region> crear(@RequestBody Region region) {
        Region nuevaRegion = regionService.guardar(region);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaRegion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> reemplazar(@PathVariable Integer id, @RequestBody Region region) {
        Region regionAct = regionService.actualizar(id, region);
        if (regionAct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(regionAct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            regionService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
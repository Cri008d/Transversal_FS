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

import com.Plantita.Plantita_BackEnd.model.Rol;
import com.Plantita.Plantita_BackEnd.service.RolService;

@RestController
@RequestMapping("/api/v1/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> obtenerTodos() {
        List<Rol> roles = rolService.obtenerTodos();
        if (roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerPorId(@PathVariable Integer id) {
        Rol rol = rolService.obtenerPorId(id);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Rol> crear(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.guardar(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> reemplazar(@PathVariable Integer id, @RequestBody Rol rol) {
        Rol rolAct = rolService.actualizar(id, rol);
        if (rolAct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rolAct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            rolService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
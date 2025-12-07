package com.Plantita.Plantita_BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Plantita.Plantita_BackEnd.model.Direcciones;
import com.Plantita.Plantita_BackEnd.repository.DireccionesRepository;

@Service
public class DireccionesService {
 
    @Autowired
    private DireccionesRepository direccionesRepository;

    // Obtener todos
    public List<Direcciones> obtenerTodos() {
        return direccionesRepository.findAll();
    }
 
    // Obtener por ID
    public Direcciones obtenerPorId(Integer id) {
        return direccionesRepository.findById(id).orElse(null);
    }

    // Guardar (Crear/Actualizar)
    public Direcciones guardar(Direcciones direccion) {
        return direccionesRepository.save(direccion);
    }

    // Eliminar por ID
    public void eliminar(Integer id) {
        Direcciones direccion = direccionesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Dirección no encontrada"));
        
        direccionesRepository.delete(direccion);
    }

    // Actualizar
    public Direcciones actualizar(Integer id, Direcciones direccion) {
        Direcciones direccionE = obtenerPorId(id);
        if (direccionE != null) {
            if (direccion.getDireccion() != null) {
                direccionE.setDireccion(direccion.getDireccion());
            }
            return direccionesRepository.save(direccionE);
        }
        return null;
    }
}

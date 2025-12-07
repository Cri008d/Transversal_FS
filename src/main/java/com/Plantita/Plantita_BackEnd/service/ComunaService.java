package com.Plantita.Plantita_BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Plantita.Plantita_BackEnd.model.Comuna;
import com.Plantita.Plantita_BackEnd.repository.ComunaRepository;

@Service
public class ComunaService {
    
    @Autowired
    private ComunaRepository comunaRepository;

    // Obtener todos
    public List<Comuna> obtenerTodos() {
        return comunaRepository.findAll();
    }
 
    // Obtener por ID
    public Comuna obtenerPorId(Integer id) {
        return comunaRepository.findById(id).orElse(null);
    }

    // Guardar (Crear/Actualizar)
    public Comuna guardar(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    // Eliminar por ID
    public void eliminar(Integer id) {
        Comuna comuna = comunaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Comuna no encontrada"));
        
        comunaRepository.delete(comuna);
    }

    // Actualizar
    public Comuna actualizar(Integer id, Comuna comuna) {
        Comuna comunaE = obtenerPorId(id);
        if (comunaE != null) {
            if (comuna.getNomComuna() != null) {
                comunaE.setNomComuna(comuna.getNomComuna());
            }
            return comunaRepository.save(comunaE);
        }
        return null;
    }
}

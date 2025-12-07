package com.Plantita.Plantita_BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Plantita.Plantita_BackEnd.model.Estado;
import com.Plantita.Plantita_BackEnd.repository.EstadoRespository;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRespository estadoRepository;

    // Obtener todos
    public List<Estado> obtenerTodos() {
        return estadoRepository.findAll();
    }
 
    // Obtener por ID
    public Estado obtenerPorId(Integer id) {
        return estadoRepository.findById(id).orElse(null);
    }

    // Guardar (Crear/Actualizar)
    public Estado guardar(Estado estado) {
        return estadoRepository.save(estado);
    }

    // Eliminar por ID
    public void eliminar(Integer id) {
        Estado estado = estadoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estado de compra no encontrado"));
        
        estadoRepository.delete(estado);
    }

    // Actualizar
    public Estado actualizar(Integer id, Estado estado) {
        Estado estadoE = obtenerPorId(id);
        if (estadoE != null) {
            if (estado.getEstadoCompra() != null) {
                estadoE.setEstadoCompra(estado.getEstadoCompra());
            }
            return estadoRepository.save(estadoE);
        }
        return null;
    }
}

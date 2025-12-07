package com.Plantita.Plantita_BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Plantita.Plantita_BackEnd.model.MetodoEnvio;
import com.Plantita.Plantita_BackEnd.repository.MetodoEnvioRepository;

@Service
public class MetodoEnvioService {
    
    @Autowired
    private MetodoEnvioRepository metodoEnvioRepository;

    // Obtener todos
    public List<MetodoEnvio> obtenerTodos() {
        return metodoEnvioRepository.findAll();
    }
 
    // Obtener por ID
    public MetodoEnvio obtenerPorId(Integer id) {
        return metodoEnvioRepository.findById(id).orElse(null);
    }

    // Guardar (Crear/Actualizar)
    public MetodoEnvio guardar(MetodoEnvio metodoEnvio) {
        return metodoEnvioRepository.save(metodoEnvio);
    }

    // Eliminar por ID
    public void eliminar(Integer id) {
        MetodoEnvio metodoEnvio = metodoEnvioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Método de envío no encontrado"));
        
        metodoEnvioRepository.delete(metodoEnvio);
    }

    // Actualizar
    public MetodoEnvio actualizar(Integer id, MetodoEnvio metodoEnvio) {
        MetodoEnvio metodoEnvioE = obtenerPorId(id);
        if (metodoEnvioE != null) {
            if (metodoEnvio.getMetEnvio() != null) {
                metodoEnvioE.setMetEnvio(metodoEnvio.getMetEnvio());
            }
            return metodoEnvioRepository.save(metodoEnvioE);
        }
        return null;
    }
}

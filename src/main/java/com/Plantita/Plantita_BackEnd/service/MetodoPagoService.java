package com.Plantita.Plantita_BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Plantita.Plantita_BackEnd.model.MetodoPago;
import com.Plantita.Plantita_BackEnd.repository.MetodoPagoRepository;

@Service
public class MetodoPagoService {
    
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    // Obtener todos
    public List<MetodoPago> obtenerTodos() {
        return metodoPagoRepository.findAll();
    }
 
    // Obtener por ID (usando Long)
    public MetodoPago obtenerPorId(Long id) {
        return metodoPagoRepository.findById(id).orElse(null);
    }

    // Guardar (Crear/Actualizar)
    public MetodoPago guardar(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    // Eliminar por ID (usando Long)
    public void eliminar(Long id) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));
        
        metodoPagoRepository.delete(metodoPago);
    }

    // Actualizar (usando Long)
    public MetodoPago actualizar(Long id, MetodoPago metodoPago) {
        MetodoPago metodoPagoE = obtenerPorId(id);
        if (metodoPagoE != null) {
            if (metodoPago.getNomMetPago() != null) {
                metodoPagoE.setNomMetPago(metodoPago.getNomMetPago());
            }
            return metodoPagoRepository.save(metodoPagoE);
        }
        return null;
    }
}

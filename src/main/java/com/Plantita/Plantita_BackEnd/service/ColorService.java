package com.Plantita.Plantita_BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Plantita.Plantita_BackEnd.model.Color;
import com.Plantita.Plantita_BackEnd.repository.ColorRepository;



@Service
public class ColorService {
    
    @Autowired
    private ColorRepository colorRepository;

    // Obtener todos
    public List<Color> obtenerTodos() {
        return colorRepository.findAll();
    }
 
    // Obtener por ID
    public Color obtenerPorId(Integer id) {
        return colorRepository.findById(id).orElse(null);
    }

    // Guardar (Crear/Actualizar)
    public Color guardar(Color color) {
        return colorRepository.save(color);
    }

    // Eliminar por ID
    public void eliminar(Integer id) {
        Color color = colorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Color no encontrado"));
        
        colorRepository.delete(color);
    }

    // Actualizar
    public Color actualizar(Integer id, Color color) {
        Color colorE = obtenerPorId(id);
        if (colorE != null) {
            if (color.getNombre() != null) {
                colorE.setNombre(color.getNombre());
            }
            if (color.getCodigo() != null) {
                colorE.setCodigo(color.getCodigo());
            }
            return colorRepository.save(colorE);
        }
        return null;
    }
}

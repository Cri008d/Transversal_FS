package com.Plantita.Plantita_BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Plantita.Plantita_BackEnd.model.Imagenes;
import com.Plantita.Plantita_BackEnd.repository.ImagenesRepository;

@Service
public class ImagenesService {
 
    @Autowired
    private ImagenesRepository imagenesRepository;

    // Obtener todos
    public List<Imagenes> obtenerTodos() {
        return imagenesRepository.findAll();
    }
 
    // Obtener por ID
    public Imagenes obtenerPorId(Integer id) {
        return imagenesRepository.findById(id).orElse(null);
    }

    // Guardar (Crear/Actualizar)
    public Imagenes guardar(Imagenes imagen) {
        return imagenesRepository.save(imagen);
    }

    // Eliminar por ID
    public void eliminar(Integer id) {
        Imagenes imagen = imagenesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));
        
        imagenesRepository.delete(imagen);
    }

    // Actualizar
    public Imagenes actualizar(Integer id, Imagenes imagen) {
        Imagenes imagenE = obtenerPorId(id);
        if (imagenE != null) {
            if (imagen.getUrlImg() != null) {
                imagenE.setUrlImg(imagen.getUrlImg());
            }
            return imagenesRepository.save(imagenE);
        }
        return null;
    }
}

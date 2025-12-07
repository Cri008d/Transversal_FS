package com.Plantita.Plantita_BackEnd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Plantita.Plantita_BackEnd.model.TiposPlanta;
import com.Plantita.Plantita_BackEnd.repository.TiposPlantaRepository;

@Service
public class TiposPlantaService {

    @Autowired
    private TiposPlantaRepository repository;

    public List<TiposPlanta> obtenerTodos() {
        return repository.findAll();
    }

    public TiposPlanta guardar(TiposPlanta tiposPlanta) {
        return repository.save(tiposPlanta);
    }

    public void eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Relación Tipo-Planta no encontrada");
        }
    }
}
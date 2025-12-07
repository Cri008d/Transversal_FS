package com.Plantita.Plantita_BackEnd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Plantita.Plantita_BackEnd.model.TipoPlanta;
import com.Plantita.Plantita_BackEnd.repository.TipoPlantaRepository;

@Service
public class TipoPlantaService {
    
    @Autowired 
    private TipoPlantaRepository repository;

    public List<TipoPlanta> obtenerTodos() { 
        return repository.findAll(); }

    public TipoPlanta obtenerPorId(Integer id) { 
        return repository.findById(id).orElse(null); }

    public TipoPlanta guardar(TipoPlanta tipo) { 
        return repository.save(tipo); }

    public void eliminar(Integer id) { 
        if(repository.existsById(id)) repository.deleteById(id);
        else throw new RuntimeException("Tipo de planta no encontrado");
    }
    public TipoPlanta actualizar(Integer id, TipoPlanta tipo) {
        TipoPlanta existe = obtenerPorId(id);
        if (existe != null) {
            if(tipo.getNombre() != null) existe.setNombre(tipo.getNombre());
            return repository.save(existe);
        }
        return null;
    }
}
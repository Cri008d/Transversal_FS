package com.Plantita.Plantita_BackEnd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Plantita.Plantita_BackEnd.model.Rol;
import com.Plantita.Plantita_BackEnd.repository.RolRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodos() { 
        return rolRepository.findAll(); }

    public Rol obtenerPorId(Integer id) { 
        return rolRepository.findById(id).orElse(null); }

    public Rol guardar(Rol rol) { 
        return rolRepository.save(rol); }

    public void eliminar(Integer id) {
        if (rolRepository.existsById(id)) rolRepository.deleteById(id);
        else throw new RuntimeException("Rol no encontrado");
    }

    public Rol actualizar(Integer id, Rol rol) {
        Rol rolE = obtenerPorId(id);
        if (rolE != null) {
            if (rol.getNombre() != null) rolE.setNombre(rol.getNombre());
            return rolRepository.save(rolE);
        }
        return null;
    }
}
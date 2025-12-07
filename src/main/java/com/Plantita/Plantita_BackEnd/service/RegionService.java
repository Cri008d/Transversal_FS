package com.Plantita.Plantita_BackEnd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Plantita.Plantita_BackEnd.model.Region;
import com.Plantita.Plantita_BackEnd.repository.RegionRepository;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> obtenerTodos() { 
        return regionRepository.findAll(); }

    public Region obtenerPorId(Integer id) { 
        return regionRepository.findById(id).orElse(null); }

    public Region guardar(Region region) { 
        return regionRepository.save(region); }

    public void eliminar(Integer id) {
        if (regionRepository.existsById(id)) regionRepository.deleteById(id);
        else throw new RuntimeException("Región no encontrada");
    }

    public Region actualizar(Integer id, Region region) {
        Region regionE = obtenerPorId(id);
        if (regionE != null) {
            if (region.getNomRegion() != null) regionE.setNomRegion(region.getNomRegion());
            return regionRepository.save(regionE);
        }
        return null;
    }
}
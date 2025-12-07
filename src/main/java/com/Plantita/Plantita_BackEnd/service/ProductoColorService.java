package com.Plantita.Plantita_BackEnd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Plantita.Plantita_BackEnd.model.ProductoColor;
import com.Plantita.Plantita_BackEnd.repository.ProductoColorRepository;

@Service
public class ProductoColorService {

    @Autowired 
    private ProductoColorRepository repository;

    public List<ProductoColor> obtenerTodos() { 
        return repository.findAll(); }

    public ProductoColor guardar(ProductoColor pc) { 
        return repository.save(pc); }

    public void eliminar(Integer id) { 
        repository.deleteById(id); }
    
    // Método opcional de actualización
    public ProductoColor actualizar(Integer id, ProductoColor pc) {
        ProductoColor ex = repository.findById(id).orElse(null);
        if(ex != null) {
            if(pc.getProducto() != null) ex.setProducto(pc.getProducto());
            if(pc.getColor() != null) ex.setColor(pc.getColor());
            return repository.save(ex);
        }
        return null;
    }
}
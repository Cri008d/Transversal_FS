package com.Plantita.Plantita_BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Plantita.Plantita_BackEnd.model.Producto;
import com.Plantita.Plantita_BackEnd.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;



    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }
 
    //Obtener un producto por su ID
    public Producto obtenerPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    //Guardar un nuevo producto 
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }


    public void eliminar(Integer id) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        productoRepository.delete(producto);
    }

    
    
    public Producto actualizar(Integer id, Producto producto) {
        Producto productoE = obtenerPorId(id);
        if (productoE != null) {
            if (producto.getNombreProducto() != null) {
                productoE.setNombreProducto(producto.getNombreProducto());
            }
            if (producto.getPrecioProducto() != null) {
                productoE.setPrecioProducto(producto.getPrecioProducto());
            }
            if (producto.getStock() != null) {
                productoE.setStock(producto.getStock());
            }
            if (producto.getCategoria() != null) {
                productoE.setCategoria(producto.getCategoria());
            }
            return productoRepository.save(productoE);
        }
        return null;
    }
    
    
}

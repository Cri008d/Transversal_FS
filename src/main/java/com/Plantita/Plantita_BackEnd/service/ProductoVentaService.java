package com.Plantita.Plantita_BackEnd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Plantita.Plantita_BackEnd.model.ProductoVenta;
import com.Plantita.Plantita_BackEnd.repository.ProductoVentaRepository;

@Service
public class ProductoVentaService {

    @Autowired
    private ProductoVentaRepository repository;

    public List<ProductoVenta> obtenerTodos() {
        return repository.findAll();
    }

    public ProductoVenta guardar(ProductoVenta productoVenta) {
        return repository.save(productoVenta);
    }

    public void eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Detalle de venta no encontrado");
        }
    }
}
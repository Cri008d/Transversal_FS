package com.Plantita.Plantita_BackEnd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Plantita.Plantita_BackEnd.model.Venta;
import com.Plantita.Plantita_BackEnd.repository.VentaRepository;

@Service
public class VentaService {
    
    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> obtenerTodos() {
        return ventaRepository.findAll();
    }

    public Venta obtenerPorId(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void eliminar(Integer id) {
        Venta venta = obtenerPorId(id);
        if (venta != null) {
            ventaRepository.delete(venta);
        } else {
            throw new RuntimeException("Venta no encontrada");
        }
    }

    public Venta actualizar(Integer id, Venta venta) {
        Venta ventaE = obtenerPorId(id);
        if (ventaE != null) {
            if (venta.getCantidad() != null) ventaE.setCantidad(venta.getCantidad());
            if (venta.getPrecioProd() != null) ventaE.setPrecioProd(venta.getPrecioProd());
            if (venta.getFechaHora() != null) ventaE.setFechaHora(venta.getFechaHora());
            if (venta.getProducto() != null) ventaE.setProducto(venta.getProducto());
            if (venta.getEstado() != null) ventaE.setEstado(venta.getEstado());
            if (venta.getMetodoEnvio() != null) ventaE.setMetodoEnvio(venta.getMetodoEnvio());
            if (venta.getMetodoPago() != null) ventaE.setMetodoPago(venta.getMetodoPago());
            if (venta.getDirecciones() != null) ventaE.setDirecciones(venta.getDirecciones());
            return ventaRepository.save(ventaE);
        }
        return null;
    }
}
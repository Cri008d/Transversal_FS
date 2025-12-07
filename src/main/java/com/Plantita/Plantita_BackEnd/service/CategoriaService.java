package com.Plantita.Plantita_BackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Plantita.Plantita_BackEnd.model.Categoria;
import com.Plantita.Plantita_BackEnd.model.Producto;
import com.Plantita.Plantita_BackEnd.repository.CategoriaRepository;
import com.Plantita.Plantita_BackEnd.repository.ProductoRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;
 

    public List<Categoria> obtenerCategorias() { 
        return categoriaRepository.findAll(); 
    }


    public Categoria obtenerCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }
    

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    public void eliminarCategoria(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        List<Producto> productos = productoRepository.findByCategoria(categoria);

        for(Producto producto : productos){
            productoService.eliminar(producto.getIdProducto());
        }
        
        categoriaRepository.delete(categoria);
    }


    public Categoria actualizar(Integer id, Categoria categoria){
        Categoria categoriaE = obtenerCategoriaPorId(id);
        if(categoriaE != null){
            if(categoria.getIdCategoria() != null){
                categoriaE.setNomCategoria(categoria.getNomCategoria());
            }
            return guardarCategoria(categoriaE);
        }
        return null;
    }

}

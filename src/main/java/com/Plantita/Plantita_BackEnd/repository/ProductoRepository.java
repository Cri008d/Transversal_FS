package com.Plantita.Plantita_BackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Plantita.Plantita_BackEnd.model.Categoria;
import com.Plantita.Plantita_BackEnd.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{


    @Query("SELECT p FROM Producto p WHERE p.nombreProducto = :nombre AND p.categoria.idCategoria = :idCategoria")
    List<Producto> buscarPorNombreYCategoria(@Param("nombre") String nombre, @Param("idCategoria") Integer idCategoria);
    
    List<Producto> findByCategoria(Categoria categoria);


}

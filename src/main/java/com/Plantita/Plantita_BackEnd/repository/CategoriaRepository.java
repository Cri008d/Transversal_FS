package com.Plantita.Plantita_BackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Plantita.Plantita_BackEnd.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    List <Categoria> findByNomCategoria(String nomCategoria);
    
}

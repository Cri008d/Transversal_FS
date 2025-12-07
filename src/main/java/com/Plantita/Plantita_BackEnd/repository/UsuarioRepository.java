package com.Plantita.Plantita_BackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Plantita.Plantita_BackEnd.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    List<Usuario> findByNombre(String nombre);

    Optional<Usuario> findByCorreo(String correo);
    
    List<Usuario> findByRolId(Integer idRol);

    
}

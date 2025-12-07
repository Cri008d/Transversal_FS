package com.Plantita.Plantita_BackEnd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Plantita.Plantita_BackEnd.model.Usuario;
import com.Plantita.Plantita_BackEnd.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminar(Integer id) {
        Usuario usuario = obtenerPorId(id);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public Usuario actualizar(Integer id, Usuario usuario) {
        Usuario usuarioE = obtenerPorId(id);
        if (usuarioE != null) {
            if (usuario.getNombre() != null) usuarioE.setNombre(usuario.getNombre());
            if (usuario.getCorreo() != null) usuarioE.setCorreo(usuario.getCorreo());
            if (usuario.getDireccion() != null) usuarioE.setDireccion(usuario.getDireccion());
            if (usuario.getContrasena() != null) usuarioE.setContrasena(usuario.getContrasena());
            return usuarioRepository.save(usuarioE);
        }
        return null;
    }
}
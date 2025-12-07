package com.Plantita.Plantita_BackEnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idUsuario;

        @Column(name= "nomUsuario" ,length = 40, nullable = false)
        private String nombre;

        @Column(unique = true, name= "correoUsuario", length = 30, nullable = false)
        private String correo;

        @Column(length = 30, nullable = false)
        private String direccion;

        @Column(name = "passUsuario", length = 30, nullable = false)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private String contrasena;

        @ManyToOne
        @JoinColumn(name = "idRol") 
        @JsonManagedReference 
        private Rol rol;

        
    
}

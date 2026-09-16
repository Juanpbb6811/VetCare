package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Roles")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    // RELACIONES

    // Relacion uno a muchos(roles de usuario)
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;
}

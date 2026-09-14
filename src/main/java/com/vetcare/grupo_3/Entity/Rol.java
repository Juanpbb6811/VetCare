package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Roles")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
}

package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "Usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el nombre es obligatorio")
    private String nombre;


    @NotBlank(message = "el correo es obligatorio")
    @Email
    private String correo;

    @NotBlank(message = "el telefono es obligatorio")
    private String telefono;
}

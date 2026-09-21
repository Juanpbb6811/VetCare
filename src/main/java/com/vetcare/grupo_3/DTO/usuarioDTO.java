package com.vetcare.grupo_3.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record usuarioDTO(
            @NotBlank(message = "El nombre es obligatorio") String nombre,
            @NotBlank(message = "El correo es obligatorio") @Email String correo,
            @NotBlank(message = "El teléfono es obligatorio") String telefono,
            @NotBlank(message = "La contraseña es obligatoria") String password
    ) {}


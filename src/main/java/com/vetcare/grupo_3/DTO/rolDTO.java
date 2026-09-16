package com.vetcare.grupo_3.DTO;

import jakarta.validation.constraints.NotBlank;

public record rolDTO(
        @NotBlank(message = "El rol es obligatorio") String nombre
) {}

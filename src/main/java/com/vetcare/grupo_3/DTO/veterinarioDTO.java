package com.vetcare.grupo_3.DTO;

import jakarta.validation.constraints.NotBlank;

public record veterinarioDTO(
        @NotBlank(message = "El registro es obligatorio") String registro,
        @NotBlank(message = "La especialidad es obligatoria") String especialidad,
        @NotBlank(message = "El estado es obligatorio") String estado
) {}

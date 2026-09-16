package com.vetcare.grupo_3.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record servicioDTO(
        @NotBlank(message = "El nombre es obligatorio") String nombre,
        LocalDateTime duracion,
        @NotNull(message = "El precio del servicio es obligatorio") Double precio,
        @NotBlank(message = "Los requisitos son obligatorios") String requisitos
) {}

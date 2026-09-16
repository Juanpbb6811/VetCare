package com.vetcare.grupo_3.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record pagoDTO(
        @NotNull(message = "El precio es obligatorio") Double precio,
        LocalDate metodo,
        @NotBlank(message = "El estado es obligatorio") String estado,
        @NotNull(message = "El ID del servicio es obligatorio") Long servicioId
) {}

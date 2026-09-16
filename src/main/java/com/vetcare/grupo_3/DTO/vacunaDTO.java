package com.vetcare.grupo_3.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record vacunaDTO(
        @NotBlank(message = "El nombre de la vacuna es obligatorio") String nombre,
        @NotNull(message = "La fecha es obligatoria") LocalDate fecha,
        @NotNull(message = "La próxima fecha de vacunación es obligatoria") LocalDate proximaFecha,
        String observacion,
        Long veterinarioId
) {}
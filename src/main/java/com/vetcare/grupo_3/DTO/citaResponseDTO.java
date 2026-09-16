package com.vetcare.grupo_3.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class citaResponseDTO {
    public record CitaResponseDTO(
            Long id,
            LocalDateTime fecha,
            String estado,
            Long usuarioId,
            Long veterinarioId
    ) {

    }
    public record citaDTO(
            @NotNull(message = "La fecha de la cita es obligatoria") LocalDateTime fecha,
            @NotBlank(message = "El estado de la cita es obligatorio") String estado,
            @NotNull(message = "El ID del usuario es obligatorio") Long usuarioId,
            @NotNull(message = "El ID del veterinario es obligatorio") Long veterinarioId
    ) {}
}

package com.vetcare.grupo_3.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record horarioDTO(
        @NotNull(message = "La hora de entrada es obligatoria") LocalDateTime horaDeEntrada,
        LocalDateTime horaDeDescanso,
        @NotNull(message = "La hora de salida es obligatoria") LocalDateTime horaDeSalida,
        @NotNull(message = "El ID del veterinario es obligatorio") Long veterinarioId
) {
    public static record historiaClinicaDTO(
                @NotBlank(message = "El motivo es obligatorio") String motivo,
                @NotBlank(message = "El diagnóstico es obligatorio") String diagnostico,
                @NotBlank(message = "El tratamiento es obligatorio") String tratamiento,
                @NotNull(message = "El ID de la mascota es obligatorio") Long mascotaId
    ) {}
}

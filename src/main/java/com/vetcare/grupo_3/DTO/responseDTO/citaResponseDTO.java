package com.vetcare.grupo_3.DTO.responseDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

    public record citaResponseDTO(
            Long id,
            LocalDateTime fecha,
            String estado,
            Long usuarioId,
            Long veterinarioId
    ) {}


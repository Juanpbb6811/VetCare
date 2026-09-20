package com.vetcare.grupo_3.DTO.responseDTO;

import java.time.LocalDate;

public record vacunaResponseDTO(
        Long id,
        String nombre,
        LocalDate fecha,
        LocalDate proximaFecha,
        String observacion,
        Long veterinarioId
) {}

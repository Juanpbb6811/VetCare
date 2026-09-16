package com.vetcare.grupo_3.DTO.responseDTO;

import java.time.LocalDateTime;

public record servicioResponseDTO(
        Long id,
        String nombre,
        LocalDateTime duracion,
        Double precio,
        String requisitos
) {}

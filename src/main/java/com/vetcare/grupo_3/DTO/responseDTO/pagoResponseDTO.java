package com.vetcare.grupo_3.DTO.responseDTO;

import java.time.LocalDate;

public record pagoResponseDTO(
        Long id,
        Double precio,
        LocalDate metodo,
        String estado,
        Long servicioId
) {}

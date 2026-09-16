package com.vetcare.grupo_3.DTO.responseDTO;

import java.time.LocalDateTime;

public record horarioResponseDTO(
        Long id,
        LocalDateTime horaDeEntrada,
        LocalDateTime horaDeDescanso,
        LocalDateTime horaDeSalida,
        Long veterinarioId
) {}

package com.vetcare.grupo_3.DTO.responseDTO;

import java.time.LocalDate;

public record mascotaResponseDTO (
        Long id,
        String nombre,
        String especie,
        String raza,
        LocalDate fechaDeNacimiento,
        Long usuarioId
) {}



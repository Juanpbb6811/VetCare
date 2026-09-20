package com.vetcare.grupo_3.DTO.responseDTO;


    public record historiaClinicaResponseDTO(
            Long id,
            String motivo,
            String diagnostico,
            String tratamiento,
            Long mascotaId
    ) {}


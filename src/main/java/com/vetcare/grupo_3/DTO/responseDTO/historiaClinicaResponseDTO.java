package com.vetcare.grupo_3.DTO.responseDTO;

public class historiaClinicaResponseDTO {
    public record HistoriaClinicaResponseDTO(
            Long id,
            String motivo,
            String diagnostico,
            String tratamiento,
            Long mascotaId
    ) {}
}

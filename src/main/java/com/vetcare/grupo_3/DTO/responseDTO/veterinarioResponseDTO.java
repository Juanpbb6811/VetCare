package com.vetcare.grupo_3.DTO.responseDTO;

public class veterinarioResponseDTO {
    public record VeterinarioResponseDTO(
            Long id,
            String registro,
            String especialidad,
            String estado
    ) {}
}

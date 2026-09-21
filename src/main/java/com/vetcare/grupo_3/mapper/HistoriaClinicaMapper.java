package com.vetcare.grupo_3.mapper;

import com.vetcare.grupo_3.Entity.HistoriaClinica;
import com.vetcare.grupo_3.DTO.historiaClinicaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.historiaClinicaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class HistoriaClinicaMapper {

    public HistoriaClinica Entidad(historiaClinicaDTO dto) {
        if (dto == null) return null;

        HistoriaClinica historia = new HistoriaClinica();

        historia.setMotivo(dto.motivo());
        historia.setDiagnostico(dto.diagnostico());
        historia.setTratamiento(dto.tratamiento());

        return historia;
    }

    public historiaClinicaResponseDTO Response(HistoriaClinica historia) {
        if (historia == null) return null;

        return new historiaClinicaResponseDTO(
                historia.getId(),
                historia.getMotivo(),
                historia.getDiagnostico(),
                historia.getTratamiento(),
                historia.getMascota() != null
                        ? historia.getMascota().getId()
                        : null
        );
    }
}

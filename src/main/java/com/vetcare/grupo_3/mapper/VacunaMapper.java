package com.vetcare.grupo_3.mapper;

import com.vetcare.grupo_3.Entity.Vacuna;
import com.vetcare.grupo_3.DTO.vacunaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.vacunaResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VacunaMapper {

    public Vacuna aEntidad(vacunaDTO dto) {
        Vacuna vacuna = new Vacuna();
        vacuna.setNombre(dto.nombre());
        vacuna.setFecha(dto.fecha());
        vacuna.setProximaFecha(dto.proximaFecha());
        vacuna.setObservacion(dto.observacion());
        return vacuna;
    }

    public vacunaResponseDTO aResponse(Vacuna vacuna) {
        return new vacunaResponseDTO(
                vacuna.getId(), vacuna.getNombre(), vacuna.getFecha(),
                vacuna.getProximaFecha(), vacuna.getObservacion(),
                vacuna.getVeterinario() != null ? vacuna.getVeterinario().getId() : null
        );
    }

    public List<vacunaResponseDTO> aResponseList(List<Vacuna> vacunas) {
        return vacunas.stream().map(this::aResponse).toList();
    }
}

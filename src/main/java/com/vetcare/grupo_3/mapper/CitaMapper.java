package com.vetcare.grupo_3.mapper;
import com.vetcare.grupo_3.Entity.Cita;
import com.vetcare.grupo_3.DTO.citaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.citaResponseDTO;
public class CitaMapper {

    public static Cita toEntity(citaDTO request) {
        if (request == null) return null;

        Cita cita = new Cita();
        cita.setFecha(request.fecha());
        cita.setEstado(request.estado());

        return cita;
    }

    public static citaResponseDTO toResponse(Cita entity) {
        if (entity == null) return null;
        return new citaResponseDTO(
                entity.getId(),
                entity.getFecha(),
                entity.getEstado(),
                entity.getUsuario() != null
                        ? entity.getUsuario().getId()
                        : null,
                entity.getMascota() != null
                        ? entity.getMascota().getId()
                        : null,
                entity.getVeterinario() != null
                        ? entity.getVeterinario().getId()
                        : null
        );
    }
}


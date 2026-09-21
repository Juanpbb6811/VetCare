package com.vetcare.grupo_3.mapper;

import com.vetcare.grupo_3.Entity.Servicio;
import com.vetcare.grupo_3.DTO.servicioDTO;
import com.vetcare.grupo_3.DTO.responseDTO.servicioResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioMapper {

    public Servicio aEntidad(servicioDTO dto) {
        Servicio servicio = new Servicio();
        servicio.setNombre(dto.nombre());
        servicio.setDuracion(dto.duracion());
        servicio.setPrecio(dto.precio());
        servicio.setRequisitos(dto.requisitos());
        return servicio;
    }

    public servicioResponseDTO aResponse(Servicio servicio) {
        return new servicioResponseDTO(
                servicio.getId(), servicio.getNombre(), servicio.getDuracion(),
                servicio.getPrecio(), servicio.getRequisitos()
        );
    }

    public List<servicioResponseDTO> aResponseList(List<Servicio> servicios) {
        return servicios.stream().map(this::aResponse).toList();
    }
}

package com.vetcare.grupo_3.mapper;

import com.vetcare.grupo_3.Entity.Rol;
import com.vetcare.grupo_3.DTO.rolDTO;
import com.vetcare.grupo_3.DTO.responseDTO.rolResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolMapper {

    public Rol aEntidad(rolDTO dto) {
        Rol rol = new Rol();
        rol.setNombre(dto.nombre());
        return rol;
    }

    // OJO: Rol.id es "int" en tu entidad (las demás usan Long).
    // Uso .longValue() implícito aquí para uniformar el DTO en Long.
    public rolResponseDTO aResponse(Rol rol) {
        return new rolResponseDTO(
                rol.getId(),
                rol.getNombre()
                );
    }

    public List<rolResponseDTO> aResponseList(List<Rol> roles) {
        return roles.stream().map(this::aResponse).toList();
    }
}

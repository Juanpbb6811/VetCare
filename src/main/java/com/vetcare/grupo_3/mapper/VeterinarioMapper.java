package com.vetcare.grupo_3.mapper;

import com.vetcare.grupo_3.Entity.Veterinario;
import com.vetcare.grupo_3.DTO.veterinarioDTO;
import com.vetcare.grupo_3.DTO.responseDTO.veterinarioResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VeterinarioMapper {

    public Veterinario aEntidad(veterinarioDTO dto) {
        Veterinario veterinario = new Veterinario();
        veterinario.setRegistro(dto.registro());
        veterinario.setEspecialidad(dto.especialidad());
        veterinario.setEstado(dto.estado());
        return veterinario;
    }

    public veterinarioResponseDTO aResponse(Veterinario veterinario) {
        return new veterinarioResponseDTO(
                veterinario.getId(),
                veterinario.getRegistro(),
                veterinario.getEspecialidad(),
                veterinario.getEstado()

        );
    }

    public List<veterinarioResponseDTO> aResponseList(List<Veterinario> veterinarios) {
        return veterinarios.stream().map(this::aResponse).toList();
    }
}

package com.vetcare.grupo_3.mapper;

import com.vetcare.grupo_3.Entity.Mascota;
import com.vetcare.grupo_3.DTO.mascotaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.mascotaResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MascotaMapper {

    // El Usuario (dueño) lo asigna el service, que es quien tiene el repository.
    public Mascota Entidad(mascotaDTO dto) {
        Mascota mascota = new Mascota();
        mascota.setNombre(dto.nombre());
        mascota.setEspecie(dto.especie());
        mascota.setRaza(dto.raza());
        mascota.setFechaDeNacimiento(dto.fechaDeNacimiento());
        return mascota;
    }

    public mascotaResponseDTO Response(Mascota mascota) {
        if (mascota == null) return null;

        return new mascotaResponseDTO(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getEspecie(),
                mascota.getRaza(),
                mascota.getFechaDeNacimiento(),
                mascota.getUsuario() != null
                        ? mascota.getUsuario().getId()
                        : null
        );
    }

    public List<mascotaResponseDTO> aResponseList(List<Mascota> mascotas) {
        return mascotas.stream().map(this::Response).toList();
    }
}

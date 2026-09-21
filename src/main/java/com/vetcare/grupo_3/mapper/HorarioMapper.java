package com.vetcare.grupo_3.mapper;

import com.vetcare.grupo_3.Entity.Horario;
import com.vetcare.grupo_3.DTO.horarioDTO;
import com.vetcare.grupo_3.DTO.responseDTO.horarioResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HorarioMapper {

    public Horario aEntidad(horarioDTO dto) {
        Horario horario = new Horario();
        horario.setHoraDeEntrada(dto.horaDeEntrada());
        horario.setHoraDeDescanso(dto.horaDeDescanso());
        horario.setHoraDeSalida(dto.horaDeSalida());
        return horario;
    }

    public horarioResponseDTO aResponse(Horario horario) {
        return new horarioResponseDTO(
                horario.getId(), horario.getHoraDeEntrada(), horario.getHoraDeDescanso(),
                horario.getHoraDeSalida(),
                horario.getVeterinario() != null ? horario.getVeterinario().getId() : null
        );
    }

    public List<horarioResponseDTO> aResponseList(List<Horario> horarios) {
        return horarios.stream().map(this::aResponse).toList();
    }
}

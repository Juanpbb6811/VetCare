package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.DTO.horarioDTO;
import com.vetcare.grupo_3.DTO.responseDTO.horarioResponseDTO;

import java.util.List;

public interface horarioService {
    List<horarioResponseDTO> listarHorarios();
    horarioResponseDTO buscarHorarioPorId(Long id);
    horarioResponseDTO guardarHorario(horarioDTO dto);
    horarioResponseDTO actualizarHorario(horarioDTO dto, Long id);
    void eliminarHorario(Long id);
    horarioResponseDTO asignarHorario(Long horarioId, Long veterinario_id);
    List<horarioResponseDTO> listarPorVeterinario(Long veterinarioId);
}

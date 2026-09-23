package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.DTO.responseDTO.vacunaResponseDTO;
import com.vetcare.grupo_3.DTO.vacunaDTO;
import com.vetcare.grupo_3.Entity.Vacuna;

import java.util.List;

public interface vacunaService {
    List<vacunaResponseDTO> listarVacuna();
    vacunaResponseDTO obtenerVacunaId(Long id);
    vacunaResponseDTO guardarVacuna(vacunaDTO dto);
    vacunaResponseDTO actualizarVacuna(vacunaDTO dto, Long id);
    void eliminarVacuna(Long id);
    vacunaResponseDTO asignarVeterinario(Long vacunaId, Long veterinarioId);
    List<vacunaResponseDTO> listarPorVeterinario(Long veterinarioId);
}

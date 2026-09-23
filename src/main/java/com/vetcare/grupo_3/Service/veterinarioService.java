package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.DTO.responseDTO.veterinarioResponseDTO;
import com.vetcare.grupo_3.DTO.veterinarioDTO;
import com.vetcare.grupo_3.Entity.Veterinario;

import java.util.List;

public interface veterinarioService {
    List<veterinarioResponseDTO> listarVeterinario();
    veterinarioResponseDTO buscarVeterinarioId(Long id);
    veterinarioResponseDTO guardarVeterinario(veterinarioDTO dto);
    veterinarioResponseDTO actualizarVeterinario(veterinarioDTO dtp, Long id);
    void eliminarVeterinario(Long id);
    veterinarioResponseDTO asignarMascota(Long mascota_id, Long veterinario_id);
    List<veterinarioResponseDTO> listarPorMascota(Long mascotaId);
}

package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.DTO.citaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.citaResponseDTO;
import com.vetcare.grupo_3.Entity.Cita;

import java.util.List;

public interface citaService {
    List<citaResponseDTO> listarCitas();
    citaResponseDTO BuscarPorId(Long id);
    citaResponseDTO actualizar(citaDTO dto, Long id);
    citaResponseDTO registrar(citaDTO dto);
    citaResponseDTO cancelar(Long id);
    citaResponseDTO pagar(Long id);
}

package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.DTO.mascotaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.mascotaResponseDTO;

import java.util.List;

public interface mascotaService {
    List<mascotaResponseDTO> ListarMascotas();

    mascotaResponseDTO BuscarporId(Long id);

    mascotaResponseDTO crear(mascotaDTO dto, Long usuarioId);

    mascotaResponseDTO actualizar(Long id, mascotaDTO dto);

    void eliminar(Long id);
}

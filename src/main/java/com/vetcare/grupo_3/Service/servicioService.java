package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.DTO.responseDTO.servicioResponseDTO;
import com.vetcare.grupo_3.DTO.servicioDTO;
import com.vetcare.grupo_3.Entity.Servicio;

import java.util.List;

public interface servicioService {
    List<servicioResponseDTO> listarServicio();
    servicioResponseDTO buscarServicioId(Long id);
    servicioResponseDTO guardarServicio(servicioDTO dto);
    servicioResponseDTO actualizarServicio(servicioDTO dto, Long id);
    void eliminarServicio(Long id);
}

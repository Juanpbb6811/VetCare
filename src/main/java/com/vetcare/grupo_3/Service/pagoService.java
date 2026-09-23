package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.DTO.pagoDTO;
import com.vetcare.grupo_3.DTO.responseDTO.pagoResponseDTO;
import com.vetcare.grupo_3.Entity.Pago;

import java.util.List;

public interface pagoService {
    List<pagoResponseDTO>listarPago();
    pagoResponseDTO obtenerPorId(Long id);
    pagoResponseDTO crearPago(pagoDTO pagoDTO);
    pagoResponseDTO actualizarPago(pagoDTO dto, Long id);
    void eliminarPago(Long id);
    pagoResponseDTO asignarServicio(Long pago_id, Long servicio_id);
}

package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.DTO.historiaClinicaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.historiaClinicaResponseDTO;

public interface historiaClinicaService {
    historiaClinicaResponseDTO BuscarHistoriaClinicaPorMascotaId(historiaClinicaDTO dto, Long mascotaId);
    historiaClinicaResponseDTO crearHistoriaClinica(historiaClinicaDTO dto, Long mascotaId);
    historiaClinicaResponseDTO actualizarHistoriaClinica(historiaClinicaDTO dto, Long mascotaId);
    void eliminarHistoriaClinica(Long id);



}

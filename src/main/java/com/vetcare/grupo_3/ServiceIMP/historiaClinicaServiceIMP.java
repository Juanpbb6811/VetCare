package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.DTO.historiaClinicaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.historiaClinicaResponseDTO;
import com.vetcare.grupo_3.Entity.HistoriaClinica;
import com.vetcare.grupo_3.Entity.Mascota;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.historiaClinicaRepository;
import com.vetcare.grupo_3.Repository.mascotaRepository;
import com.vetcare.grupo_3.Service.historiaClinicaService;
import com.vetcare.grupo_3.mapper.HistoriaClinicaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class historiaClinicaServiceIMP implements historiaClinicaService {

    private final historiaClinicaRepository historiaClinicaRepository;
    private final mascotaRepository mascotaRepository;
    private final HistoriaClinicaMapper historiaClinicaMapper;



    @Override
    @Transactional(readOnly = true)
    public historiaClinicaResponseDTO actualizarHistoriaClinica(historiaClinicaDTO dto, Long mascotaId) {
        HistoriaClinica existente = historiaClinicaRepository.findByMascotaId(mascotaId)
                .orElseThrow(() -> new ResourceNotFoundException("Historia clínica no encontrada para mascota con ID: " + mascotaId));
        existente.setMotivo(dto.motivo());
        existente.setDiagnostico(dto.diagnostico());
        existente.setTratamiento(dto.tratamiento());
        return historiaClinicaMapper.Response(historiaClinicaRepository.save(existente));
    }

    @Override
    @Transactional(readOnly = true)
    public historiaClinicaResponseDTO BuscarHistoriaClinicaPorMascotaId(historiaClinicaDTO dto, Long mascotaId) {
        HistoriaClinica historia = historiaClinicaRepository.findByMascotaId(mascotaId)
                .orElseThrow(() -> new ResourceNotFoundException("Historia clínica no encontrada para mascota con ID: " + mascotaId));
        return historiaClinicaMapper.Response(historia);
    }

    @Override
    @Transactional
    public historiaClinicaResponseDTO crearHistoriaClinica(historiaClinicaDTO dto, Long mascotaId) {
        Mascota mascota = mascotaRepository.findById(mascotaId)
            .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada con ID: " + mascotaId));
        HistoriaClinica historiaClinica = historiaClinicaMapper.Entidad(dto);
        historiaClinica.setMascota(mascota);
        return historiaClinicaMapper.Response(historiaClinicaRepository.save(historiaClinica));
    }



    @Override
    @Transactional
    public void eliminarHistoriaClinica(Long id) {
        if (!historiaClinicaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Historia clínica no encontrada con ID: " + id);
        }
        historiaClinicaRepository.deleteById(id);
    }
}
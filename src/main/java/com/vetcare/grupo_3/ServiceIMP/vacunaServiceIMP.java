package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.DTO.vacunaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.vacunaResponseDTO;
import com.vetcare.grupo_3.Entity.Vacuna;
import com.vetcare.grupo_3.Entity.Veterinario;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;

import com.vetcare.grupo_3.Repository.vacunaRepository;
import com.vetcare.grupo_3.Repository.veterinarioRepository;
import com.vetcare.grupo_3.Service.vacunaService;
import com.vetcare.grupo_3.mapper.VacunaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class vacunaServiceIMP implements vacunaService {

    private final vacunaRepository vacunaRepository;
    private final veterinarioRepository veterinarioRepository;
    private final VacunaMapper vacunaMapper;



    @Override
    @Transactional(readOnly = true)
    public List<vacunaResponseDTO> listarVacuna() {
        return vacunaMapper.aResponseList(vacunaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public vacunaResponseDTO obtenerVacunaId(Long id) {
        Vacuna vacuna = vacunaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vacuna no encontrada con ID: " + id));
        return vacunaMapper.aResponse(vacuna);
    }

    @Override
    @Transactional
    public vacunaResponseDTO guardarVacuna(vacunaDTO dto) {
        Vacuna vacuna = vacunaMapper.aEntidad(dto);
        if (dto.veterinarioId() != null) {
            Veterinario veterinario = veterinarioRepository.findById(dto.veterinarioId())
                    .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado"));
            vacuna.setVeterinario(veterinario);
        }
        return vacunaMapper.aResponse(vacunaRepository.save(vacuna));
    }

    @Override
    @Transactional
    public vacunaResponseDTO actualizarVacuna(vacunaDTO dto, Long id) {
        Vacuna existente = vacunaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vacuna no encontrada con ID: " + id));
        existente.setNombre(dto.nombre());
        existente.setFecha(dto.fecha());
        existente.setProximaFecha(dto.proximaFecha());
        existente.setObservacion(dto.observacion());
        return vacunaMapper.aResponse(vacunaRepository.save(existente));
    }

    @Override
    @Transactional
    public void eliminarVacuna(Long id) {
        if (!vacunaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vacuna no encontrada con ID: " + id);
        }
        vacunaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public vacunaResponseDTO asignarVeterinario(Long vacunaId, Long veterinarioId) {
        Vacuna vacuna = vacunaRepository.findById(vacunaId)
                .orElseThrow(() -> new ResourceNotFoundException("Vacuna no encontrada con ID: " + vacunaId));
        Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con ID: " + veterinarioId));
        vacuna.setVeterinario(veterinario);
        return vacunaMapper.aResponse(vacunaRepository.save(vacuna));
    }

    @Override
    @Transactional(readOnly = true)
    public List<vacunaResponseDTO> listarPorVeterinario(Long veterinarioId) {
        if (!veterinarioRepository.existsById(veterinarioId)) {
            throw new ResourceNotFoundException("Veterinario no encontrado con ID: " + veterinarioId);
        }
        return vacunaMapper.aResponseList(vacunaRepository.findByVeterinarioId(veterinarioId));
    }
}
package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.DTO.veterinarioDTO;
import com.vetcare.grupo_3.DTO.responseDTO.veterinarioResponseDTO;
import com.vetcare.grupo_3.Entity.Veterinario;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.veterinarioRepository;
import com.vetcare.grupo_3.Service.veterinarioService;
import com.vetcare.grupo_3.mapper.VeterinarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class veterinarioServiceIMP implements veterinarioService {

    private final veterinarioRepository veterinarioRepository;
    private final VeterinarioMapper veterinarioMapper;



    @Override
    @Transactional(readOnly = true)
    public List<veterinarioResponseDTO> listarVeterinario() {
        return veterinarioMapper.aResponseList(veterinarioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public veterinarioResponseDTO buscarVeterinarioId(Long id) {
        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con ID: " + id));
        return veterinarioMapper.aResponse(veterinario);
    }

    @Override
    @Transactional
    public veterinarioResponseDTO guardarVeterinario(veterinarioDTO dto) {
        Veterinario veterinario = veterinarioMapper.aEntidad(dto);
        return veterinarioMapper.aResponse(veterinarioRepository.save(veterinario));
    }

    @Override
    @Transactional
    public veterinarioResponseDTO actualizarVeterinario(veterinarioDTO dto, Long id) {
        Veterinario existente = veterinarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con ID: " + id));
        existente.setRegistro(dto.registro());
        existente.setEspecialidad(dto.especialidad());
        existente.setEstado(dto.estado());
        return veterinarioMapper.aResponse(veterinarioRepository.save(existente));
    }

    @Override
    @Transactional
    public void eliminarVeterinario(Long id) {
        if (!veterinarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Veterinario no encontrado con ID: " + id);
        }
        veterinarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public veterinarioResponseDTO asignarMascota(Long mascota_id, Long veterinario_id) {
        Veterinario veterinario = veterinarioRepository.findById(veterinario_id)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con ID: " + veterinario_id));
        return veterinarioMapper.aResponse(veterinarioRepository.save(veterinario));
    }

    @Override
    @Transactional(readOnly = true)
    public List<veterinarioResponseDTO> listarPorMascota(Long mascotaId) {
        return veterinarioMapper.aResponseList(veterinarioRepository.findByMascotasId(mascotaId));
    }
}
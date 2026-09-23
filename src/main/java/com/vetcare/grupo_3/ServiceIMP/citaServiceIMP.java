package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.DTO.citaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.citaResponseDTO;
import com.vetcare.grupo_3.Entity.Cita;
import com.vetcare.grupo_3.Entity.Usuario;
import com.vetcare.grupo_3.Entity.Veterinario;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.*;
import com.vetcare.grupo_3.Service.citaService;
import com.vetcare.grupo_3.mapper.CitaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class citaServiceIMP implements citaService {

    private final citaRepository citaRepository;
    private final usuarioRepository  usuarioRepository;
    private final  veterinarioRepository  veterinarioRepository;


    @Override
    @Transactional(readOnly = true)
    public List<citaResponseDTO> listarCitas() {
        return citaRepository.findAll().stream()
                .map(CitaMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public citaResponseDTO BuscarPorId(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return CitaMapper.toResponse(cita);
    }

    @Override
    @Transactional
    public citaResponseDTO registrar(citaDTO dto) {
        Cita cita = CitaMapper.toEntity(dto);

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Veterinario veterinario = veterinarioRepository.findById(dto.veterinarioId())
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));

        cita.setUsuario(usuario);
        cita.setVeterinario(veterinario);

        return CitaMapper.toResponse(citaRepository.save(cita));
    }

    @Override
    @Transactional
    public citaResponseDTO actualizar(citaDTO dto, Long id) {
        Cita citaExistente = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        citaExistente.setFecha(dto.fecha());
        citaExistente.setEstado(dto.estado());

        if (dto.usuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            citaExistente.setUsuario(usuario);
        }

        if (dto.veterinarioId() != null) {
            Veterinario veterinario = veterinarioRepository.findById(dto.veterinarioId())
                    .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
            citaExistente.setVeterinario(veterinario);
        }

        return CitaMapper.toResponse(citaRepository.save(citaExistente));
    }

    @Override
    @Transactional
    public citaResponseDTO cancelar(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada con ID: " + id));
        cita.setEstado("PAGADA");
        return CitaMapper.toResponse(citaRepository.save(cita));
    }

    @Override
    @Transactional
    public citaResponseDTO pagar(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada con ID: " + id));
        cita.setEstado("PAGADA");
        return CitaMapper.toResponse(citaRepository.save(cita));
    }
}

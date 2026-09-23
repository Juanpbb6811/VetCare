package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.DTO.horarioDTO;
import com.vetcare.grupo_3.DTO.responseDTO.horarioResponseDTO;
import com.vetcare.grupo_3.Entity.Horario;
import com.vetcare.grupo_3.Entity.Veterinario;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.horarioRepository;
import com.vetcare.grupo_3.Repository.veterinarioRepository;
import com.vetcare.grupo_3.Service.horarioService;
import com.vetcare.grupo_3.mapper.HorarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class horarioServiceIMP implements horarioService {

    private final horarioRepository horarioRepository;
    private final veterinarioRepository veterinarioRepository;
    private final HorarioMapper horarioMapper;



    @Override
    @Transactional(readOnly = true)
    public List<horarioResponseDTO> listarHorarios() {
        return horarioMapper.aResponseList(horarioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public horarioResponseDTO buscarHorarioPorId(Long id) {
        Horario horario = horarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado con ID: " + id));
        return horarioMapper.aResponse(horario);
    }

    @Override
    @Transactional
    public horarioResponseDTO guardarHorario(horarioDTO dto) {
        Horario horario = horarioMapper.aEntidad(dto);
        Veterinario veterinario = veterinarioRepository.findById(dto.veterinarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con ID: " + dto.veterinarioId()));
        horario.setVeterinario(veterinario);
        return horarioMapper.aResponse(horarioRepository.save(horario));
    }

    @Override
    @Transactional
    public horarioResponseDTO actualizarHorario(horarioDTO dto, Long id) {
        Horario existente = horarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado con ID: " + id));
        existente.setHoraDeEntrada(dto.horaDeEntrada());
        existente.setHoraDeDescanso(dto.horaDeDescanso());
        existente.setHoraDeSalida(dto.horaDeSalida());
        return horarioMapper.aResponse(horarioRepository.save(existente));
    }

    @Override
    @Transactional
    public void eliminarHorario(Long id) {
        if (!horarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Horario no encontrado con ID: " + id);
        }
        horarioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public horarioResponseDTO asignarHorario(Long horarioId, Long veterinario_id) {
        Horario horario = horarioRepository.findById(horarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado con ID: " + horarioId));
        Veterinario veterinario = veterinarioRepository.findById(veterinario_id)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con ID: " + veterinario_id));
        horario.setVeterinario(veterinario);
        return horarioMapper.aResponse(horarioRepository.save(horario));
    }

    @Override
    @Transactional(readOnly = true)
    public List<horarioResponseDTO> listarPorVeterinario(Long veterinarioId) {
        if (!veterinarioRepository.existsById(veterinarioId)) {
            throw new ResourceNotFoundException("Veterinario no encontrado con ID: " + veterinarioId);
        }
        return horarioMapper.aResponseList(horarioRepository.findByVeterinarioId(veterinarioId));
    }
}

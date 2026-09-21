package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.Horario;
import com.vetcare.grupo_3.Entity.Veterinario;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.horarioRepository;
import com.vetcare.grupo_3.Repository.veterinarioRepository;
import com.vetcare.grupo_3.Service.horarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class horarioServiceIMP implements horarioService {

    private final horarioRepository horarioRepository;
    private final veterinarioRepository veterinarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Horario> listarHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Horario buscarHorarioPorId(Long id) {
        return horarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado con ID: " + id));
    }

    @Override
    @Transactional
    public Horario guardarHorario(Horario horario) {

        return horarioRepository.save(horario);
    }

    @Override
    @Transactional
    public Horario actualizarHorario(Horario horario, Long id) {
        Horario horarioExistente = horarioRepository.findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Horario no encontrado" + id));
        return horarioRepository.save(horarioExistente);
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
    @Transactional
    public Horario asignarHorario(Long horarioId, Long veterinario_id) {
        Horario horario = horarioRepository.findById(horarioId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Horario no encontrado con ID: " + horarioId));

        Veterinario veterinario = veterinarioRepository.findById(veterinario_id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Veterinario no encontrado con ID: " + veterinario_id));

        horario.setVeterinario(veterinario);

        return horarioRepository.save(horario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Horario> listarPorVeterinario(Long veterinarioId) {
        Veterinario vet = veterinarioRepository.findById(veterinarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con ID: " + veterinarioId));
        return vet.getHorarios();
    }
}
package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.Mascota;
import com.vetcare.grupo_3.Entity.Vacuna;
import com.vetcare.grupo_3.Entity.Veterinario;
import com.vetcare.grupo_3.Repository.mascotaRepository;
import com.vetcare.grupo_3.Repository.vacunaRepository;
import com.vetcare.grupo_3.Repository.veterinarioRepository;
import com.vetcare.grupo_3.Service.vacunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class vacunaServiceIMP  implements vacunaService {

    private final vacunaRepository vacunaRepository;
    private final veterinarioRepository veterinarioRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Vacuna> listarVacuna() {
        return vacunaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vacuna obtenerVacunaId(Long id) {
        return vacunaRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Vacuna no encontrada" + id));
    }

    @Override
    @Transactional
    public Vacuna guardarVacuna(Vacuna vacuna) {
        return vacunaRepository.save(vacuna);
    }

    @Override
    @Transactional
    public Vacuna actualizarVacuna(Vacuna vacuna, Long id) {
        Vacuna vacunaExistente = vacunaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Vacuna no encontrada con ID: " + id));
        return vacunaRepository.save(vacunaExistente);
    }

    @Override
    @Transactional
    public void eliminarVacuna(Long id) {
        if (!vacunaRepository.existsById(id)) {
            throw new RuntimeException(
                    "Vacuna no encontrada con ID: " + id);
        }
        vacunaRepository.deleteById(id);
    }

    @Override
    public Vacuna asignarVeterinario(Long vacunaId, Long veterinarioId) {
        Vacuna vacuna = vacunaRepository.findById(vacunaId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Vacuna no encontrada con ID: " + vacunaId));

        Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Veterinario no encontrado con ID: " + veterinarioId));

        vacuna.setVeterinario(veterinario);
        return vacunaRepository.save(vacuna);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vacuna> listarPorVeterinario(Long veterinarioId) {
        if (!veterinarioRepository.existsById(veterinarioId)) {
            throw new RuntimeException(
                    "Veterinario no encontrado con ID: " + veterinarioId);
        }

        return vacunaRepository.findByVeterinarioId(veterinarioId);
    }
}


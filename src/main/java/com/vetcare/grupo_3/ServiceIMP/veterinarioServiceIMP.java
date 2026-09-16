package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.Mascota;
import com.vetcare.grupo_3.Entity.Veterinario;
import com.vetcare.grupo_3.Repository.mascotaRepository;
import com.vetcare.grupo_3.Repository.veterinarioRepository;
import com.vetcare.grupo_3.Service.veterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class veterinarioServiceIMP implements veterinarioService {
    private final veterinarioRepository veterinarioRepository;
    private final mascotaRepository mascotaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Veterinario> listarVeterinario() {
        return veterinarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinario buscarVeterinarioId(Long id) {
        return veterinarioRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("veterinario no encontrado"+id));
    }

    @Override
    @Transactional
    public Veterinario guardarVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    @Transactional
    public Veterinario actualizarVeterinario(Veterinario veterinario, Long id) {
        Veterinario veterinarioExistente =  veterinarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Veterinario no encontrado con ID: " + id));
        return veterinarioRepository.save(veterinarioExistente);
    }

    @Override
    @Transactional
    public void eliminarVeterinario(Long id) {
        if (!veterinarioRepository.existsById(id)) {
            throw new RuntimeException(
                    "Veterinario no encontrado con ID: " + id);
        }

        veterinarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Veterinario asignarMascota(Long mascota_id, Long veterinario_id) {
        Veterinario veterinario =
                veterinarioRepository.findById(veterinario_id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Veterinario no encontrado con ID: "
                                                + veterinario_id));
        Mascota mascota =
                mascotaRepository.findById(mascota_id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Mascota no encontrada con ID: "
                                                + mascota_id));
        mascotaRepository.save(mascota);
        return veterinarioRepository.save(veterinario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Veterinario> listarPorMascota(Long mascotaId) {
        Mascota mascota =
                mascotaRepository.findById(mascotaId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Mascota no encontrada con ID: "
                                                + mascotaId));

        return mascota.getVeterinarios();
    }
}

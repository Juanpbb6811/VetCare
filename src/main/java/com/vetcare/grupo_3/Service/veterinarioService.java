package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.Entity.Veterinario;

import java.util.List;

public interface veterinarioService {
    List<Veterinario> listarVeterinario();
    Veterinario buscarVeterinarioId(Long id);
    Veterinario guardarVeterinario(Veterinario veterinario);
    Veterinario actualizarVeterinario(Veterinario veterinario, Long id);
    void eliminarVeterinario(Long id);
    Veterinario asignarMascota(Long mascota_id, Long veterinario_id);
    List<Veterinario> listarPorMascota(Long mascotaId);
}

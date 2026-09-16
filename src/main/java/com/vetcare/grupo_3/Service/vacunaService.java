package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.Entity.Vacuna;

import java.util.List;

public interface vacunaService {
    List<Vacuna> listarVacuna();
    Vacuna obtenerVacunaId(Long id);
    Vacuna guardarVacuna(Vacuna vacuna);
    Vacuna actualizarVacuna(Vacuna vacuna, Long id);
    void eliminarVacuna(Long id);
    Vacuna asignarVeterinario(Long vacunaId, Long veterinarioId);
    List<Vacuna> listarPorVeterinario(Long veterinarioId);
}

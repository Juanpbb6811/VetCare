package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.Entity.Horario;

import java.util.List;

public interface horarioService {
    List<Horario> listarHorarios();
    Horario buscarHorarioPorId(Long id);
    Horario guardarHorario(Horario horario);
    Horario actualizarHorario(Horario horario, Long id);
    void eliminarHorario(Long id);
    Horario asignarHorario(Long horarioId, Long veterinario_id);
    List<Horario> listarPorVeterinario(Long veterinarioId);
}

package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.Entity.Cita;

import java.util.List;

public interface citaService {
    List<Cita> listarCitas();
    Cita BuscarPorId(Long id);
    Cita actualizar(Cita cita, Long id);
    Cita registrar(Cita cita,
                   Long usuarioId, Long mascotaId, Long veterinarioId, Long servicioId);
    Cita cancelar(Long id);
    Cita pagar(Long id);

  }

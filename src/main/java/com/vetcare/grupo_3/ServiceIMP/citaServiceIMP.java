package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.*;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.*;
import com.vetcare.grupo_3.Service.citaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class citaServiceIMP implements citaService {
    private final citaRepository citaRepository;
    private final usuarioRepository usuarioRepository;
    private final mascotaRepository mascotaRepository;
    private final veterinarioRepository veterinarioRepository;
    private final servicioRepository servicioRepository;
    @Override
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita BuscarPorId(Long id) {
        return citaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada con ID: " + id));
    }

    @Override
    public Cita actualizar(Cita cita, Long id) {
        Cita citaExistente = BuscarPorId(id);
        citaExistente.setFecha(cita.getFecha());
        citaExistente.setEstado(cita.getEstado());
        return citaRepository.save(citaExistente);
    }

    @Override
    public Cita registrar(Cita cita, Long usuarioId, Long mascotaId, Long veterinarioId, Long servicioId) {
        if (usuarioId != null) {
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + usuarioId));
            cita.setUsuario(usuario);
        }
        if (mascotaId != null) {
            Mascota mascota = mascotaRepository.findById(mascotaId)
                    .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada con ID: " + mascotaId));
            cita.setMascota(mascota);
        }
        if (veterinarioId != null) {
            Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                    .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con ID: " + veterinarioId));
            cita.setVeterinario(veterinario);
        }
        if (servicioId != null) {
            Servicio servicio = servicioRepository.findById(servicioId)
                    .orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado con ID: " + servicioId));
        }
        return citaRepository.save(cita);
    }

    @Override
    public Cita cancelar(Long id) {
        Cita cita = BuscarPorId(id);
        cita.setEstado("CANCELADA");
        return citaRepository.save(cita);
    }

    @Override
    public Cita pagar(Long id) {
        Cita cita = BuscarPorId(id);
        cita.setEstado("PAGADA");
        return citaRepository.save(cita);
    }
}

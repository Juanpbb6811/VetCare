package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.*;
import com.vetcare.grupo_3.Repository.*;
import com.vetcare.grupo_3.Service.citaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cita BuscarPorId(Long id) {
        return citaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cita no encontrado"));
    }


    @Override
    @Transactional
    public Cita actualizar(Cita cita, Long id) {
        return null;
    }



    @Override
    @Transactional
    public Cita registrar(Cita cita, Long usuarioId, Long mascotaId, Long veterinarioId, Long servicioId) {

        Usuario usuario = usuarioRepository
                    .findById(usuarioId)
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Usuario no encontrado"));

            Mascota mascota = mascotaRepository
                    .findById(mascotaId)
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Mascota no encontrada"));

            Veterinario veterinario = veterinarioRepository
                    .findById(veterinarioId)
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Veterinario no encontrado"));

            Servicio servicio = servicioRepository
                    .findById(servicioId)
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Servicio no encontrado"));

            return citaRepository.save(cita);
    }

    @Override
    @Transactional
    public Cita cancelar(Long id) {

        Cita cita = BuscarPorId(id);
        return citaRepository.save(cita);
    }

    @Override
    @Transactional
    public Cita pagar(Long id) {
        Cita cita = BuscarPorId(id);
        return citaRepository.save(cita);
    }
  }

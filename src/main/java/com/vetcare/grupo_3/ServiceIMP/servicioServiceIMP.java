package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.Servicio;
import com.vetcare.grupo_3.Repository.servicioRepository;
import com.vetcare.grupo_3.Service.servicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class servicioServiceIMP implements servicioService {
    private final servicioRepository servicioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> listarServicio() {
        return servicioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Servicio buscarServicioId(Long id) {
        return servicioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Servicio no encontrado"));
    }

    @Override
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio actualizarServicio(Servicio servicio, Long id) {
        Servicio existente = buscarServicioId(id);
        return servicioRepository.save(existente);
    }

    @Override
    public void eliminarServicio(Long id) {
        Servicio servicio = buscarServicioId(id);
        servicioRepository.delete(servicio);
    }
}

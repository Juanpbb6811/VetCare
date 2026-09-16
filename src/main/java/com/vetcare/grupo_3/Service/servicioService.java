package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.Entity.Servicio;

import java.util.List;

public interface servicioService {
    List<Servicio> listarServicio();
    Servicio buscarServicioId(Long id);
    Servicio guardarServicio(Servicio servicio);
    Servicio actualizarServicio(Servicio servicio, Long id);
    void eliminarServicio(Long id);
}

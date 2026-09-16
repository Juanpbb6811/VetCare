package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.Entity.Pago;

import java.util.List;

public interface pagoService {
    List<Pago>listarPago();
    Pago obtenerPorId(Long id);
    Pago crearPago(Pago pago);
    Pago actualizarPago(Pago pago, Long id);
    void eliminarPago(Long id);
    Pago asignarServicio(Long pago_id, Long servicio_id);
}

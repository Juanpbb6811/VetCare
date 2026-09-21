package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.Pago;
import com.vetcare.grupo_3.Repository.pagoRepository;
import com.vetcare.grupo_3.Service.pagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class pagoServiceIMP implements pagoService {
    private final pagoRepository pagoRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Pago> listarPago() {
        return pagoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pago obtenerPorId(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pago no encontrado"));
    }

    @Override
    @Transactional
    public Pago crearPago(Pago pago) {

        return pagoRepository.save(pago);
    }

    @Override
    @Transactional
    public Pago actualizarPago(Pago pago, Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pago no encontrado"));
    }

    @Override
    public void eliminarPago(Long id) {
        Pago Pago = obtenerPorId(id);
        pagoRepository.deleteById(id);
    }

    @Override
    public Pago asignarServicio(Long pago_id, Long servicio_id) {
        return null;
    }
}

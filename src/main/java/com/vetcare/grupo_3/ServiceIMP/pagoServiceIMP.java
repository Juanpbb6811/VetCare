package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.DTO.pagoDTO;
import com.vetcare.grupo_3.DTO.responseDTO.pagoResponseDTO;
import com.vetcare.grupo_3.Entity.Pago;
import com.vetcare.grupo_3.Entity.Servicio;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.pagoRepository;
import com.vetcare.grupo_3.Repository.servicioRepository;
import com.vetcare.grupo_3.Service.pagoService;
import com.vetcare.grupo_3.mapper.PagoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class pagoServiceIMP implements pagoService {

    private final pagoRepository pagoRepository;
    private final servicioRepository servicioRepository;
    private final PagoMapper pagoMapper;



    @Override
    public List<pagoResponseDTO> listarPago() {
        return pagoMapper.ResponseList(pagoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public pagoResponseDTO obtenerPorId(Long id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con ID: " + id));
        return pagoMapper.aResponse(pago);
    }

    @Override
    @Transactional
    public pagoResponseDTO crearPago(pagoDTO dto) {
        Pago pago = pagoMapper.Entidad(dto);
        Servicio servicio = servicioRepository.findById(dto.servicioId())
                .orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado con ID: " + dto.servicioId()));
        pago.setServicio(servicio);
        return pagoMapper.aResponse(pagoRepository.save(pago));
    }

    @Override
    @Transactional
    public pagoResponseDTO actualizarPago(pagoDTO dto, Long id) {
        Pago existente = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con ID: " + id));
        existente.setPrecio(dto.precio());
        existente.setMetodo(dto.metodo());
        existente.setEstado(dto.estado());
        return pagoMapper.aResponse(pagoRepository.save(existente));
    }

    @Override
    @Transactional
    public void eliminarPago(Long id) {
        if (!pagoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pago no encontrado con ID: " + id);
        }
        pagoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public pagoResponseDTO asignarServicio(Long pago_id, Long servicio_id) {
        Pago pago = pagoRepository.findById(pago_id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con ID: " + pago_id));
        Servicio servicio = servicioRepository.findById(servicio_id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado con ID: " + servicio_id));
        pago.setServicio(servicio);
        return pagoMapper.aResponse(pagoRepository.save(pago));
    }
}
package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.DTO.servicioDTO;
import com.vetcare.grupo_3.DTO.responseDTO.servicioResponseDTO;
import com.vetcare.grupo_3.Entity.Servicio;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.servicioRepository;
import com.vetcare.grupo_3.Service.servicioService;
import com.vetcare.grupo_3.mapper.ServicioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class servicioServiceIMP implements servicioService {

    private final servicioRepository servicioRepository;
    private final ServicioMapper servicioMapper;


    @Override
    @Transactional(readOnly = true)
    public List<servicioResponseDTO> listarServicio() {
        return servicioMapper.aResponseList(servicioRepository.findAll());
    }

    @Override
    @Transactional
    public servicioResponseDTO buscarServicioId(Long id) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado con ID: " + id));
        return servicioMapper.aResponse(servicio);
    }

    @Override
    @Transactional
    public servicioResponseDTO guardarServicio(servicioDTO dto) {
        Servicio servicio = servicioMapper.aEntidad(dto);
        return servicioMapper.aResponse(servicioRepository.save(servicio));
    }

    @Override
    @Transactional
    public servicioResponseDTO actualizarServicio(servicioDTO dto, Long id) {
        Servicio existente = servicioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado con ID: " + id));
        existente.setNombre(dto.nombre());
        existente.setDuracion(dto.duracion());
        existente.setPrecio(dto.precio());
        existente.setRequisitos(dto.requisitos());
        return servicioMapper.aResponse(servicioRepository.save(existente));
    }

    @Override
    @Transactional
    public void eliminarServicio(Long id) {
        if (!servicioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Servicio no encontrado con ID: " + id);
        }
        servicioRepository.deleteById(id);
    }
}
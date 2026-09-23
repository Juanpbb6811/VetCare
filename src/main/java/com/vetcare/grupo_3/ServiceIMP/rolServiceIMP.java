package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.DTO.rolDTO;
import com.vetcare.grupo_3.DTO.responseDTO.rolResponseDTO;
import com.vetcare.grupo_3.Entity.Rol;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.rolRepository;
import com.vetcare.grupo_3.Service.rolService;
import com.vetcare.grupo_3.mapper.RolMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class rolServiceIMP implements rolService {

    private final rolRepository rolRepository;
    private final RolMapper rolMapper;


    @Override
    @Transactional(readOnly = true)
    public List<rolResponseDTO> listarRol() {
        return rolMapper.aResponseList(rolRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public rolResponseDTO buscarRolId(Long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con ID: " + id));
        return rolMapper.aResponse(rol);
    }

    @Override
    @Transactional
    public rolResponseDTO guardarRol(rolDTO dto) {
        Rol rol = rolMapper.aEntidad(dto);
        return rolMapper.aResponse(rolRepository.save(rol));
    }

    @Override
    @Transactional
    public rolResponseDTO actualizarRol(rolDTO dto, Long id) {
        Rol existente = rolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con ID: " + id));
        existente.setNombre(dto.nombre());
        return rolMapper.aResponse(rolRepository.save(existente));
    }

    @Override
    @Transactional
    public void eliminarRol(Long id) {
        if (!rolRepository.existsById(id)) {
            throw new ResourceNotFoundException("Rol no encontrado con ID: " + id);
        }
        rolRepository.deleteById(id);
    }
}
package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.DTO.mascotaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.mascotaResponseDTO;
import com.vetcare.grupo_3.Entity.Mascota;
import com.vetcare.grupo_3.Entity.Usuario;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.mascotaRepository;
import com.vetcare.grupo_3.Repository.usuarioRepository;
import com.vetcare.grupo_3.Service.mascotaService;
import com.vetcare.grupo_3.mapper.MascotaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class mascotaServiceIMP implements mascotaService {

    private final mascotaRepository mascotaRepository;
    private final usuarioRepository usuarioRepository;
    private final MascotaMapper mascotaMapper;


    @Override
    public List<mascotaResponseDTO> ListarMascotas() {
        return mascotaMapper.aResponseList(mascotaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public mascotaResponseDTO BuscarporId(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada con ID: " + id));
        return mascotaMapper.Response(mascota);
    }

    @Override
    @Transactional
    public mascotaResponseDTO crear(mascotaDTO dto, Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + dto.usuarioId()));
        Mascota mascota = mascotaMapper.Entidad(dto);
        mascota.setUsuario(usuario);
        return mascotaMapper.Response(mascotaRepository.save(mascota));
    }

    @Override
    @Transactional
    public mascotaResponseDTO actualizar(Long id, mascotaDTO dto) {
        Mascota existente = mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada con ID: " + id));
        existente.setNombre(dto.nombre());
        existente.setEspecie(dto.especie());
        existente.setRaza(dto.raza());
        existente.setFechaDeNacimiento(dto.fechaDeNacimiento());
        return mascotaMapper.Response(mascotaRepository.save(existente));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!mascotaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Mascota no encontrada con ID: " + id);
        }
        mascotaRepository.deleteById(id);
    }
}
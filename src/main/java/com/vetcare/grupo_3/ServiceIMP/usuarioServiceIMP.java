package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.DTO.usuarioDTO;
import com.vetcare.grupo_3.DTO.responseDTO.usuarioResponseDTO;
import com.vetcare.grupo_3.Entity.Rol;
import com.vetcare.grupo_3.Entity.Usuario;
import com.vetcare.grupo_3.Exception.BadRequestException;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.rolRepository;
import com.vetcare.grupo_3.Repository.usuarioRepository;
import com.vetcare.grupo_3.Service.usuarioService;
import com.vetcare.grupo_3.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class usuarioServiceIMP implements usuarioService {

    private final usuarioRepository usuarioRepository;
    private final rolRepository rolRepository;
    private final UsuarioMapper usuarioMapper;



    @Override
    @Transactional(readOnly = true)
    public List<usuarioResponseDTO> ListarUsuarios() {
        return usuarioMapper.aResponseList(usuarioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public usuarioResponseDTO BuscarUsuarioId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
        return usuarioMapper.aResponse(usuario);
    }

    @Override
    @Transactional
    public usuarioResponseDTO guardarUsuario(usuarioDTO dto) {
        Usuario usuario = usuarioMapper.aEntidad(dto);
        return usuarioMapper.aResponse(usuarioRepository.save(usuario));
    }

    @Override
    @Transactional
    public usuarioResponseDTO actualizarUsuario(usuarioDTO dto, Long id) {
        Usuario existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
        existente.setNombre(dto.nombre());
        existente.setCorreo(dto.correo());
        existente.setTelefono(dto.telefono());
        existente.setPassword(dto.password());
        return usuarioMapper.aResponse(usuarioRepository.save(existente));
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public usuarioResponseDTO asignarRol(Long id_usuario, Long rol_id) {
        Usuario usuario = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id_usuario));
        Rol rol = rolRepository.findById(rol_id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con ID: " + rol_id));
        usuario.setRol(rol);
        return usuarioMapper.aResponse(usuarioRepository.save(usuario));
    }

    @Override
    @Transactional(readOnly = true)
    public usuarioResponseDTO autenticar(String correo, String password) {
        Usuario usuario = usuarioRepository.findByCorreoAndPassword(correo, password)
                .orElseThrow(() -> new BadRequestException("Credenciales inválidas: correo o contraseña incorrectos"));
        return usuarioMapper.aResponse(usuario);
    }
}
package com.vetcare.grupo_3.mapper;

import com.vetcare.grupo_3.Entity.Usuario;
import com.vetcare.grupo_3.DTO.usuarioDTO;
import com.vetcare.grupo_3.DTO.responseDTO.usuarioResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapper {

    public Usuario aEntidad(usuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.nombre());
        usuario.setCorreo(dto.correo());
        usuario.setPassword(dto.password());
        usuario.setTelefono(dto.telefono());
        return usuario;
    }

    public usuarioResponseDTO aResponse(Usuario usuario) {
        return new usuarioResponseDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getTelefono(),
                usuario.getPassword(),
                usuario.getRol() != null
                        ? usuario.getRol().getId()
                        : null
        );
    }

    public List<usuarioResponseDTO> aResponseList(List<Usuario> usuarios) {
        return usuarios.stream().map(this::aResponse).toList();
    }
}

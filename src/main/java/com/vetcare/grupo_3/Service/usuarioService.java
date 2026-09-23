package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.DTO.responseDTO.usuarioResponseDTO;
import com.vetcare.grupo_3.DTO.usuarioDTO;
import com.vetcare.grupo_3.Entity.Usuario;

import java.util.List;

public interface usuarioService {
    List<usuarioResponseDTO> ListarUsuarios();
    usuarioResponseDTO BuscarUsuarioId(Long id);
    usuarioResponseDTO guardarUsuario(usuarioDTO dto);
    usuarioResponseDTO actualizarUsuario(usuarioDTO dto, Long id);
    void eliminarUsuario(Long id);
    usuarioResponseDTO asignarRol(Long id_usuario, Long rol_id);
    usuarioResponseDTO autenticar(String correo, String password);

}

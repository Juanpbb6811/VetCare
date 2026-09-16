package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.Entity.Usuario;

import java.util.List;

public interface usuarioService {
    List<Usuario> ListarUsuarios();
    Usuario BuscarUsuarioId(Long id);
    Usuario guardarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Usuario usuario, Long id);
    void eliminarUsuario(Long id);
    Usuario asignarRol(Long id_usuario, Long rol_id);
    Usuario autenticar(String correo, String password);

}

package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.Usuario;
import com.vetcare.grupo_3.Repository.usuarioRepository;
import com.vetcare.grupo_3.Service.usuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class usuarioServiceIMP implements usuarioService {

    private final usuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> ListarUsuarios() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario BuscarUsuarioId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    @Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario actualizarUsuario(Usuario usuario, Long id) {
        Usuario existente = BuscarUsuarioId(id);
        usuario.setId(existente.getId()); // ¡Corrección aplicada aquí!
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long id) {
        Usuario usuario = BuscarUsuarioId(id);
        repository.delete(usuario);
    }

    @Override
    public Usuario asignarRol(Long id_usuario, Long rol_id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario autenticar(String correo, String password) {
        Usuario usuario = repository.findBycorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Validación de contraseña básica
        if (!usuario.getPassword().equals(password)) {
            throw new RuntimeException("Credenciales inválidas");
        }
        return usuario;
    }
}
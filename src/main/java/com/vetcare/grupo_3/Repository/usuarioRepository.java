package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findBycorreo(String correo);
}

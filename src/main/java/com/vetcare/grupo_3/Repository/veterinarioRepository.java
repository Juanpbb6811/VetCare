package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface veterinarioRepository extends JpaRepository<Veterinario, Long> {
    List<Veterinario> findByMascotasId(Long id);
}

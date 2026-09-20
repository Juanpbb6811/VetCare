package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface veterinarioRepository extends JpaRepository<Veterinario, Long> {
}

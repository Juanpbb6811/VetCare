package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface horarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByVeterinarioId(Long veterinarioId);
}

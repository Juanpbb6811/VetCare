package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface vacunaRepository extends JpaRepository<Vacuna, Long> {
    List<Vacuna> findByVeterinarioId(Long veterinarioId);
}

package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface citaRepository extends JpaRepository<Cita, Long> {
}

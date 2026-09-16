package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Cita;
import com.vetcare.grupo_3.Entity.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface historiaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
    Optional<HistoriaClinica> findByMascotaId(Long mascotaId);
}

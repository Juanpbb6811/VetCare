package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Cita;
import com.vetcare.grupo_3.Entity.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface historiaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {

}

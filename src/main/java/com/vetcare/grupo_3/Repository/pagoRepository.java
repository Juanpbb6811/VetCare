package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Cita;
import com.vetcare.grupo_3.Entity.Pago;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pagoRepository extends JpaRepository<Pago, Long> {
}

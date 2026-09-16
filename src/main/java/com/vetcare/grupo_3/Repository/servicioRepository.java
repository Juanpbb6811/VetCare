package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Rol;
import com.vetcare.grupo_3.Entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface servicioRepository extends JpaRepository<Servicio, Long> {
}

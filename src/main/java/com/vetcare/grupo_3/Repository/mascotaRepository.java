package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface mascotaRepository extends JpaRepository<Mascota, Long> {
}

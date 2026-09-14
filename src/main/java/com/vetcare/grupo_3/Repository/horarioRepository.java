package com.vetcare.grupo_3.Repository;

import com.vetcare.grupo_3.Entity.Cita;
import com.vetcare.grupo_3.Entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface horarioRepository extends JpaRepository<Horario, Long> {

}

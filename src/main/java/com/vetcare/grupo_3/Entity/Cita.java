package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name = "Citas")
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private String estado;

    // RELACIONES
    // Relacion uno a muchos (citas)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private com.vetcare.grupo_3.Entity.Usuario usuario;
}
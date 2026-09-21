package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;

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
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

}
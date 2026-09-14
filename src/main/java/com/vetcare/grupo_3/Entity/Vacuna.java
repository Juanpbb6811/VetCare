package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Vacunas")
@Data
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el nombre es obligatorio")
    private String nombre;

    private LocalDate fecha;

    private LocalDate proximaFecha;

    @NotBlank(message = "las observaciones son obligatorias")
    private String observacion;
}

package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Servicio")
@Data
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = " el nombre es obligatorio")
    private String nombre;

    private LocalDateTime duracion;

    @NotNull(message = "el precio del servicio es obligatorio")
    private double precio;

    @NotBlank(message = "los requisitos son obligatorios")
    private String requisitos;


}

package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Table(name = "Pagos")
@Data
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double precio;
    private LocalDate metodo;
    private String estado;

    // RELACIONES

    // Relacion uno a muchos (servicios)
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;


}


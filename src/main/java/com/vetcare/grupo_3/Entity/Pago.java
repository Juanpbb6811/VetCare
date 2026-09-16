package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import lombok.Data;

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


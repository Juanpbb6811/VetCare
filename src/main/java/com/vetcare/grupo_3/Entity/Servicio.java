package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Servicios")
@Data
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDateTime duracion;
    private double precio;
    private String requisitos;

    // RELACIONES
    // Relacion uno a muchos(pagos)
    @OneToMany(mappedBy = "Pago")
    private List<Pago> pagos;

    // Relacion muchos a muchos(mascota)
    @ManyToMany(mappedBy = "servicios")
    private List<Mascota> mascotas;



}

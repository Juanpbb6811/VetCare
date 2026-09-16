package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Vacunas")
@Data
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el nombre de la vacuna es obligatorio")
    private String nombre;

    @NotNull(message = "la fecha es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "la proxima fecha de vacunacion es obligatoria")
    private LocalDate proximaFecha;

    private String observacion;

    //RELACIONES

    //Relacion muchos a muchos
    @ManyToMany(mappedBy = "vacunas")
    private List<Mascota> mascotas;

    // Muchos a uno con Veterinario
    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;




}

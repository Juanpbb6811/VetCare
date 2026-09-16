package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "mascotas")
@Data
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "la especie es obligatoria")
    private String especie;

    @NotBlank(message = "la raza es obligatoria")
    private String raza;

    @NotNull(message = "la fecha de nacimiento es obligatoria")
    private LocalDate fechaDeNacimiento;


    // Relación muchos a uno con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    // Relación uno a uno con Historia Clínica
    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL)
    private HistoriaClinica historiaclinica;


    // Relación muchos a muchos con Vacunas
    @ManyToMany
    @JoinTable(
            name = "mascota_vacuna",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "vacuna_id")
    )
    private List<Vacuna> vacunas;


    // Relación muchos a muchos con Veterinarios
    @ManyToMany(mappedBy = "mascotas")
    private List<Veterinario> veterinarios;


    // Relación muchos a muchos con Servicios
    @ManyToMany
    @JoinTable(
            name = "mascota_servicio",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private List<Servicio> servicios;
}
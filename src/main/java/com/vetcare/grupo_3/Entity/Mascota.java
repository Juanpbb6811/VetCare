package com.vetcare.grupo_3.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
}

package com.vetcare.grupo_3.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
public record mascotaDTO(
        @NotBlank(message = "El nombre es obligatorio") String nombre,
        @NotBlank(message = "La especie es obligatoria") String especie,
        @NotBlank(message = "La raza es obligatoria") String raza,
        @NotNull(message = "La fecha de nacimiento es obligatoria") LocalDate fechaDeNacimiento,
        @NotNull(message = "El id de usuario es obligatorio") Long usuarioId
) {}





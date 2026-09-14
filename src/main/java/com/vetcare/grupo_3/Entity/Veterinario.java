package com.vetcare.grupo_3.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "veterinarios")
@Data
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "el registro es obligatorio")
    private String registro;

    @NotBlank(message = "la especialidad es obligatoria")
    private String especialidad;

    @NotBlank(message = "el estado es obligatorio")
    private String estado;

    // Ignoramos la lista de mascotas para evitar el bucle N:M
    @ManyToMany(mappedBy = "veterinarios")
    @JsonIgnore
    private List<Mascota> mascotas;
}
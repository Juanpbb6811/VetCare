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

    // RELACIONES

    //Relacion muchos a muchos
    @ManyToMany(mappedBy = "veterinarios")
    @JsonIgnore
    private List<Mascota> mascotas;

    //Relacion un a muchos
    @OneToMany(mappedBy = "veterinario")
    private List<Horario> horarios;

    // Relacion Uno a muchos con Vacuna
    @OneToMany(mappedBy = "veterinario")
    private List<Vacuna> vacunas;
}
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
    private String registro;
    private String especialidad;
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

    // relacion cita
    @OneToMany(mappedBy = "veterinario")
    private List<Cita> citas;
}
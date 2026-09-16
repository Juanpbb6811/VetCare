package com.vetcare.grupo_3.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "historias_clinicas")
@Data
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el motivo es obligatorio")
    private String motivo;

    @NotBlank(message = "el diagnostico es obligatorio")
    private String diagnostico;

    @NotBlank(message = "el tratamiento es obligatorio")
    private String tratamiento;

    // RELACIONES

    // Relacion uno a uno(mascota)
    @OneToOne
    @JoinColumn(name = "mascota_id")
    @JsonIgnore
    private Mascota mascota;
}
package com.vetcare.grupo_3.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "historias_clinicas")
@Data
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motivo;
    private String diagnostico;
    private String tratamiento;

    // RELACIONES

    // Relacion uno a uno(mascota)
    @OneToOne
    @JoinColumn(name = "mascota_id")
    @JsonIgnore
    private com.vetcare.grupo_3.Entity.Mascota mascota;
}
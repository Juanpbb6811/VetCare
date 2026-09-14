package com.vetcare.grupo_3.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "horarios")
@Data
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime horaDeEntrada;
    private LocalDateTime horaDeDescanso;
    private LocalDateTime horaDeSalida;
}

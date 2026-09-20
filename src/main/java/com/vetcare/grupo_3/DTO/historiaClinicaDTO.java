package com.vetcare.grupo_3.DTO;

import jakarta.validation.constraints.NotBlank;

public class historiaClinicaDTO {
    @NotBlank(message = "el motivo es obligatorio") String motivo;
    @NotBlank(message = "el diagnostico es obligatorio")  String diagnostico;
    @NotBlank(message = "el tratamiento es obligatorio")     String tratamiento;
}

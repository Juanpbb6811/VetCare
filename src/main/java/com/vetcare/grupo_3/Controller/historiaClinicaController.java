package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.Entity.HistoriaClinica;
import com.vetcare.grupo_3.Service.historiaClinicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/historias-clinicas")
@RequiredArgsConstructor
@Tag(name = "Historias Clínicas", description = "API para la gestión de los diagnósticos y tratamientos de las mascotas")
public class historiaClinicaController {

    private final historiaClinicaService service;

    @GetMapping("/mascota/{mascotaId}")
    @Operation(summary = "Consultar la historia clínica asociada a una mascota específica")
    public ResponseEntity<HistoriaClinica> buscarPorMascotaId(@PathVariable Long mascotaId) {
        return ResponseEntity.ok(service.BuscarHistoriaClinicaPorMascotaId(mascotaId));
    }

    @PostMapping("/mascota/{mascotaId}")
    @Operation(summary = "Crear el registro de historia clínica para una mascota")
    public ResponseEntity<HistoriaClinica> crearHistoriaClinica(
            @Valid @RequestBody HistoriaClinica historiaClinica,
            @PathVariable Long mascotaId) {
        // @Valid asegurará que el motivo, diagnóstico y tratamiento no vengan vacíos
        return new ResponseEntity<>(service.crearHistoriaClinica(historiaClinica, mascotaId), HttpStatus.CREATED);
    }
}
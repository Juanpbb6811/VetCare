package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.DTO.historiaClinicaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.historiaClinicaResponseDTO;
import com.vetcare.grupo_3.Service.historiaClinicaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/historias-clinicas")
public class historiaClinicaController {

    private final historiaClinicaService service;

    public historiaClinicaController(historiaClinicaService service) {
        this.service = service;
    }

    // Nota: Se envía el DTO según la firma de tu interfaz historiaClinicaService
    @GetMapping("/mascota/{mascotaId}")
    public ResponseEntity<historiaClinicaResponseDTO> buscarPorMascotaId(
            @PathVariable Long mascotaId,
            @Valid @RequestBody(required = false) historiaClinicaDTO dto) {
        return ResponseEntity.ok(service.BuscarHistoriaClinicaPorMascotaId(dto, mascotaId));
    }

    @PostMapping("/mascota/{mascotaId}")
    public ResponseEntity<historiaClinicaResponseDTO> crear(
            @PathVariable Long mascotaId,
            @Valid @RequestBody historiaClinicaDTO dto) {
        return new ResponseEntity<>(service.crearHistoriaClinica(dto, mascotaId), HttpStatus.CREATED);
    }

    @PutMapping("/mascota/{mascotaId}")
    public ResponseEntity<historiaClinicaResponseDTO> actualizar(
            @PathVariable Long mascotaId,
            @Valid @RequestBody historiaClinicaDTO dto) {
        return ResponseEntity.ok(service.actualizarHistoriaClinica(dto, mascotaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarHistoriaClinica(id);
        return ResponseEntity.noContent().build();
    }
}
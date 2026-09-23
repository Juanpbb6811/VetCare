package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.DTO.responseDTO.vacunaResponseDTO;
import com.vetcare.grupo_3.DTO.vacunaDTO;
import com.vetcare.grupo_3.Service.vacunaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacunas")
@AllArgsConstructor
public class vacunaController {

    private final vacunaService service;

    @GetMapping
    public ResponseEntity<List<vacunaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarVacuna());
    }

    @GetMapping("/{id}")
    public ResponseEntity<vacunaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerVacunaId(id));
    }

    @PostMapping
    public ResponseEntity<vacunaResponseDTO> guardar(@Valid @RequestBody vacunaDTO dto) {
        return new ResponseEntity<>(service.guardarVacuna(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<vacunaResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody vacunaDTO dto) {
        return ResponseEntity.ok(service.actualizarVacuna(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarVacuna(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{vacunaId}/veterinario/{veterinarioId}")
    public ResponseEntity<vacunaResponseDTO> asignarVeterinario(@PathVariable Long vacunaId, @PathVariable Long veterinarioId) {
        return ResponseEntity.ok(service.asignarVeterinario(vacunaId, veterinarioId));
    }

    @GetMapping("/veterinario/{veterinarioId}")
    public ResponseEntity<List<vacunaResponseDTO>> listarPorVeterinario(@PathVariable Long veterinarioId) {
        return ResponseEntity.ok(service.listarPorVeterinario(veterinarioId));
    }
}
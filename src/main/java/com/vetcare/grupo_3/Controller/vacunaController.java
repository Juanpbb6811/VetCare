package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.Entity.Vacuna;
import com.vetcare.grupo_3.Service.vacunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacunas")
@RequiredArgsConstructor
public class vacunaController {

    private final vacunaService vacunaService;

    @GetMapping
    public ResponseEntity<List<Vacuna>> listarTodas() {
        return ResponseEntity.ok(vacunaService.listarVacuna());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacuna> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vacunaService.obtenerVacunaId(id));
    }

    @PostMapping
    public ResponseEntity<Vacuna> guardar(@RequestBody Vacuna vacuna) {
        return ResponseEntity.ok(vacunaService.guardarVacuna(vacuna));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacuna> actualizar(
            @PathVariable Long id,
            @RequestBody Vacuna vacuna) {

        return ResponseEntity.ok(vacunaService.actualizarVacuna(vacuna, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        vacunaService.eliminarVacuna(id);
        return ResponseEntity.noContent().build();
    }

    // ASIGNAR VETERINARIO A LA VACUNA
    @PutMapping("/{vacunaId}/veterinario/{veterinarioId}")
    public ResponseEntity<Vacuna> asignarVeterinario(
            @PathVariable Long vacunaId,
            @PathVariable Long veterinarioId) {

        return ResponseEntity.ok(
                vacunaService.asignarVeterinario(vacunaId, veterinarioId)
        );
    }

    // VACUNAS APLICADAS POR UN VETERINARIO
    @GetMapping("/veterinario/{veterinarioId}")
    public ResponseEntity<List<Vacuna>> listarPorVeterinario(
            @PathVariable Long veterinarioId) {

        return ResponseEntity.ok(
                vacunaService.listarPorVeterinario(veterinarioId));
    }
}
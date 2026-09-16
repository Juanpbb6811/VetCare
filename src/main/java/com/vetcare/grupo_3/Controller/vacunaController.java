package com.vetcare.grupo_3.Controller;

import com.vetcare.grupo_3.Entity.Vacuna;
import com.vetcare.grupo_3.Service.vacunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacunaciones")
@RequiredArgsConstructor
public class vacunaController {

    private final vacunaService vacunaService;

    @GetMapping
    public ResponseEntity<List<Vacuna>> listarTodas() {
        return ResponseEntity.ok(
                vacunaService.listarTodas()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacuna> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                vacunaService.obtenerVacunaId(id)
        );
    }

    @PostMapping
    public ResponseEntity<Vacuna> guardar(
            @RequestBody Vacuna vacuna) {

        return ResponseEntity.ok(
                vacunaService.guardarVacuna(vacuna)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacuna> actualizar(
            @PathVariable Long id,
            @RequestBody Vacuna vacuna) {

        return ResponseEntity.ok(
                vacunaService.actualizarVacuna(id, vacuna)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        vacunacionService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

    // ASIGNAR MASCOTA
    @PutMapping("/{vacunacionId}/mascota/{mascotaId}")
    public ResponseEntity<Vacunacion> asignarMascota(
            @PathVariable Long vacunacionId,
            @PathVariable Long mascotaId) {

        return ResponseEntity.ok(
                vacunacionService.asignarMascota(
                        vacunacionId,
                        mascotaId
                )
        );
    }

    // ASIGNAR VACUNA
    @PutMapping("/{vacunacionId}/vacuna/{vacunaId}")
    public ResponseEntity<Vacunacion> asignarVacuna(
            @PathVariable Long vacunacionId,
            @PathVariable Long vacunaId) {

        return ResponseEntity.ok(
                vacunacionService.asignarVacuna(
                        vacunacionId,
                        vacunaId
                )
        );
    }

    // ASIGNAR VETERINARIO
    @PutMapping("/{vacunacionId}/veterinario/{veterinarioId}")
    public ResponseEntity<Vacunacion> asignarVeterinario(
            @PathVariable Long vacunacionId,
            @PathVariable Long veterinarioId) {

        return ResponseEntity.ok(
                vacunacionService.asignarVeterinario(
                        vacunacionId,
                        veterinarioId
                )
        );
    }

    // CONSULTAR VACUNAS DE UNA MASCOTA
    @GetMapping("/mascota/{mascotaId}")
    public ResponseEntity<List<Vacunacion>> listarPorMascota(
            @PathVariable Long mascotaId) {

        return ResponseEntity.ok(
                vacunacionService.listarPorMascota(mascotaId)
        );
    }

    // CONSULTAR VACUNACIONES DE UN VETERINARIO
    @GetMapping("/veterinario/{veterinarioId}")
    public ResponseEntity<List<Vacunacion>> listarPorVeterinario(
            @PathVariable Long veterinarioId) {

        return ResponseEntity.ok(
                vacunacionService.listarPorVeterinario(veterinarioId)
        );
    }

    // CONSULTAR POR TIPO DE VACUNA
    @GetMapping("/vacuna/{vacunaId}")
    public ResponseEntity<List<Vacunacion>> listarPorVacuna(
            @PathVariable Long vacunaId) {

        return ResponseEntity.ok(
                vacunacionService.listarPorVacuna(vacunaId)
        );
    }
}

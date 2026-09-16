package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.Entity.Horario;
import com.vetcare.grupo_3.Service.horarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
@RequiredArgsConstructor
public class horarioController {

    private final horarioService horarioService;

    @GetMapping
    public ResponseEntity<List<Horario>> listarTodos() {
        return ResponseEntity.ok(horarioService.listarHorarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(horarioService.buscarHorarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<Horario> guardar(@RequestBody Horario horario) {
        return ResponseEntity.ok(horarioService.guardarHorario(horario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> actualizar(
            @PathVariable Long id,
            @RequestBody Horario horario) {

        return ResponseEntity.ok(horarioService.actualizarHorario(horario, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        horarioService.eliminarHorario(id);
        return ResponseEntity.noContent().build();
    }

    // ASIGNAR HORARIO A UN VETERINARIO
    @PutMapping("/{horarioId}/veterinario/{veterinarioId}")
    public ResponseEntity<Horario> asignarHorario(
            @PathVariable Long horarioId,
            @PathVariable Long veterinarioId) {

        return ResponseEntity.ok(
                horarioService.asignarHorario(horarioId, veterinarioId)
        );
    }

    // HORARIOS DE UN VETERINARIO
    @GetMapping("/veterinario/{veterinarioId}")
    public ResponseEntity<List<Horario>> listarPorVeterinario(
            @PathVariable Long veterinarioId) {

        return ResponseEntity.ok(
                horarioService.listarPorVeterinario(veterinarioId)
        );
    }
}

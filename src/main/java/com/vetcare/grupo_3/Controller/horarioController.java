package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.DTO.horarioDTO;
import com.vetcare.grupo_3.DTO.responseDTO.horarioResponseDTO;
import com.vetcare.grupo_3.Service.horarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
@AllArgsConstructor
public class horarioController {

    private final horarioService service;

    @GetMapping
    public ResponseEntity<List<horarioResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarHorarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<horarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarHorarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<horarioResponseDTO> guardar(@Valid @RequestBody horarioDTO dto) {
        return new ResponseEntity<>(service.guardarHorario(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<horarioResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody horarioDTO dto) {
        return ResponseEntity.ok(service.actualizarHorario(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarHorario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{horarioId}/veterinario/{veterinarioId}")
    public ResponseEntity<horarioResponseDTO> asignarVeterinario(@PathVariable Long horarioId, @PathVariable Long veterinarioId) {
        return ResponseEntity.ok(service.asignarHorario(horarioId, veterinarioId));
    }

    @GetMapping("/veterinario/{veterinarioId}")
    public ResponseEntity<List<horarioResponseDTO>> listarPorVeterinario(@PathVariable Long veterinarioId) {
        return ResponseEntity.ok(service.listarPorVeterinario(veterinarioId));
    }
}
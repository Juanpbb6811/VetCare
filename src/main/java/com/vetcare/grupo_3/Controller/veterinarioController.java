package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.DTO.responseDTO.veterinarioResponseDTO;
import com.vetcare.grupo_3.DTO.veterinarioDTO;
import com.vetcare.grupo_3.Service.veterinarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@AllArgsConstructor
public class veterinarioController {

    private final veterinarioService service;

    @GetMapping
    public ResponseEntity<List<veterinarioResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarVeterinario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<veterinarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarVeterinarioId(id));
    }

    @PostMapping
    public ResponseEntity<veterinarioResponseDTO> guardar(@Valid @RequestBody veterinarioDTO dto) {
        return new ResponseEntity<>(service.guardarVeterinario(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<veterinarioResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody veterinarioDTO dto) {
        return ResponseEntity.ok(service.actualizarVeterinario(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarVeterinario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{veterinario_id}/mascota/{mascota_id}")
    public ResponseEntity<veterinarioResponseDTO> asignarMascota(@PathVariable Long mascota_id, @PathVariable Long veterinario_id) {
        return ResponseEntity.ok(service.asignarMascota(mascota_id, veterinario_id));
    }

    @GetMapping("/mascota/{mascotaId}")
    public ResponseEntity<List<veterinarioResponseDTO>> listarPorMascota(@PathVariable Long mascotaId) {
        return ResponseEntity.ok(service.listarPorMascota(mascotaId));
    }
}
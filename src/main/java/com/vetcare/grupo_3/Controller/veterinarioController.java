package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.Service.veterinarioService;
import com.vetcare.grupo_3.Entity.Veterinario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@RequiredArgsConstructor

public class veterinarioController {

    private final veterinarioService veterinarioService;

    @GetMapping
    public ResponseEntity<List<Veterinario>> listarTodos() {
        return ResponseEntity.ok(
                veterinarioService.listarVeterinario()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                veterinarioService.buscarVeterinarioId(id)
        );
    }

    @PostMapping
    public ResponseEntity<Veterinario> guardar(
            @RequestBody Veterinario veterinario) {

        return ResponseEntity.ok(
                veterinarioService.guardarVeterinario(veterinario)
        );
    }

}


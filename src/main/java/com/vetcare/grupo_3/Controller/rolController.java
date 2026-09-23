package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.DTO.rolDTO;
import com.vetcare.grupo_3.DTO.responseDTO.rolResponseDTO;
import com.vetcare.grupo_3.Service.rolService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class rolController {

    private final rolService service;


    @GetMapping
    public ResponseEntity<List<rolResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarRol());
    }

    @GetMapping("/{id}")
    public ResponseEntity<rolResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarRolId(id));
    }

    @PostMapping
    public ResponseEntity<rolResponseDTO> guardar(@Valid @RequestBody rolDTO dto) {
        return new ResponseEntity<>(service.guardarRol(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<rolResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody rolDTO dto) {
        return ResponseEntity.ok(service.actualizarRol(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }
}
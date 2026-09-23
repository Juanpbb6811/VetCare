package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.DTO.mascotaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.mascotaResponseDTO;
import com.vetcare.grupo_3.Service.mascotaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class mascotaController {

    private final mascotaService service;

    public mascotaController(mascotaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<mascotaResponseDTO>> listar() {
        return ResponseEntity.ok(service.ListarMascotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<mascotaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.BuscarporId(id));
    }

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<mascotaResponseDTO> crear(@PathVariable Long usuarioId, @Valid @RequestBody mascotaDTO dto) {
        return new ResponseEntity<>(service.crear(dto, usuarioId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<mascotaResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody mascotaDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
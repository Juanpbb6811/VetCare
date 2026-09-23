package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.DTO.citaDTO;
import com.vetcare.grupo_3.DTO.responseDTO.citaResponseDTO;
import com.vetcare.grupo_3.Service.citaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@AllArgsConstructor
public class citaController {

    private final citaService service;

    @GetMapping
    public ResponseEntity<List<citaResponseDTO>> listarCitas() {
        return ResponseEntity.ok(service.listarCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<citaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.BuscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<citaResponseDTO> registrar(@Valid @RequestBody citaDTO dto) {
        return new ResponseEntity<>(service.registrar(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<citaResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody citaDTO dto) {
        return ResponseEntity.ok(service.actualizar(dto, id));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<citaResponseDTO> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok(service.cancelar(id));
    }

    @PutMapping("/{id}/pagar")
    public ResponseEntity<citaResponseDTO> pagar(@PathVariable Long id) {
        return ResponseEntity.ok(service.pagar(id));
    }
}
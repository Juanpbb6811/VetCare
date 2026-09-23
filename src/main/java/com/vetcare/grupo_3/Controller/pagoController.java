package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.DTO.pagoDTO;
import com.vetcare.grupo_3.DTO.responseDTO.pagoResponseDTO;
import com.vetcare.grupo_3.Service.pagoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@AllArgsConstructor
public class pagoController {

    private final pagoService service;

    @GetMapping
    public ResponseEntity<List<pagoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarPago());
    }

    @GetMapping("/{id}")
    public ResponseEntity<pagoResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<pagoResponseDTO> crearPago(@Valid @RequestBody pagoDTO dto) {
        return new ResponseEntity<>(service.crearPago(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<pagoResponseDTO> actualizarPago(@PathVariable Long id, @Valid @RequestBody pagoDTO dto) {
        return ResponseEntity.ok(service.actualizarPago(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {
        service.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{pagoId}/servicio/{servicioId}")
    public ResponseEntity<pagoResponseDTO> asignarServicio(@PathVariable Long pagoId, @PathVariable Long servicioId) {
        return ResponseEntity.ok(service.asignarServicio(pagoId, servicioId));
    }
}
package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.DTO.responseDTO.servicioResponseDTO;
import com.vetcare.grupo_3.DTO.servicioDTO;
import com.vetcare.grupo_3.Service.servicioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@AllArgsConstructor
public class servicioController {

    private final servicioService service;


    @GetMapping
    public ResponseEntity<List<servicioResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarServicio());
    }

    @GetMapping("/{id}")
    public ResponseEntity<servicioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarServicioId(id));
    }

    @PostMapping
    public ResponseEntity<servicioResponseDTO> guardar(@Valid @RequestBody servicioDTO dto) {
        return new ResponseEntity<>(service.guardarServicio(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<servicioResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody servicioDTO dto) {
        return ResponseEntity.ok(service.actualizarServicio(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }
}
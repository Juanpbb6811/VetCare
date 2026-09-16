package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.Entity.Servicio;
import com.vetcare.grupo_3.Service.servicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
public class servicioController {

    private final servicioService servicioService;

    @GetMapping
    public ResponseEntity<List<Servicio>> listarTodos() {
        return ResponseEntity.ok(servicioService.listarServicio());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicioService.buscarServicioId(id));
    }

    @PostMapping
    public ResponseEntity<Servicio> guardar(@RequestBody Servicio servicio) {
        return ResponseEntity.ok(servicioService.guardarServicio(servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> actualizar(
            @PathVariable Long id,
            @RequestBody Servicio servicio) {

        return ResponseEntity.ok(servicioService.actualizarServicio(servicio, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }
}
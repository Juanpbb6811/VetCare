package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.Entity.Cita;
import com.vetcare.grupo_3.Service.citaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class citaController {

    private final citaService citaService;

    // LISTAR CITAS
    @GetMapping
    public ResponseEntity<List<Cita>> listarTodas() {
        return ResponseEntity.ok(citaService.listarCitas());
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.BuscarPorId(id));
    }

    // REGISTRAR CITA (necesita los 4 ids de las relaciones)
    @PostMapping
    public ResponseEntity<Cita> registrar(
            @RequestBody Cita cita,
            @RequestParam Long usuarioId,
            @RequestParam Long mascotaId,
            @RequestParam Long veterinarioId,
            @RequestParam Long servicioId) {

        return ResponseEntity.ok(
                citaService.registrar(cita, usuarioId, mascotaId, veterinarioId, servicioId)
        );
    }

    // ACTUALIZAR CITA
    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizar(
            @PathVariable Long id,
            @RequestBody Cita cita) {

        return ResponseEntity.ok(citaService.actualizar(cita, id));
    }

    // CANCELAR CITA
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Cita> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.cancelar(id));
    }

    // PAGAR CITA
    @PutMapping("/{id}/pagar")
    public ResponseEntity<Cita> pagar(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.pagar(id));
    }
}
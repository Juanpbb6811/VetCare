package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.Entity.Pago;
import com.vetcare.grupo_3.Service.pagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class pagoController {

    private final pagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> listarTodos() {
        return ResponseEntity.ok(pagoService.listarPago());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Pago> guardar(@RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.crearPago(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(
            @PathVariable Long id,
            @RequestBody Pago pago) {

        return ResponseEntity.ok(pagoService.actualizarPago(pago, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pagoService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }

    // ASIGNAR UN SERVICIO AL PAGO
    @PutMapping("/{pagoId}/servicio/{servicioId}")
    public ResponseEntity<Pago> asignarServicio(
            @PathVariable Long pagoId,
            @PathVariable Long servicioId) {

        return ResponseEntity.ok(
                pagoService.asignarServicio(pagoId, servicioId)
        );
    }
}
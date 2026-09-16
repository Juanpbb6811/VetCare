package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.Entity.Mascota;
import com.vetcare.grupo_3.Service.mascotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
@Tag(name = "Mascotas", description = "API para la gestión de las mascotas de la clínica")
public class mascotaController {

    private final mascotaService service;

    @GetMapping
    @Operation(summary = "Listar todas las mascotas")
    public ResponseEntity<List<Mascota>> listarMascotas() {
        return ResponseEntity.ok(service.ListarMascotas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar una mascota por su ID")
    public ResponseEntity<Mascota> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.BuscarporId(id));
    }

    // Fíjate en la ruta: Pide el usuarioId en la URL para enviárselo a tu servicio
    @PostMapping("/usuario/{usuarioId}")
    @Operation(summary = "Registrar una nueva mascota asignada a un usuario")
    public ResponseEntity<Mascota> crearMascota(@Valid @RequestBody Mascota mascota, @PathVariable Long usuarioId) {
        return new ResponseEntity<>(service.crear(mascota, usuarioId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar los datos de una mascota")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable Long id, @Valid @RequestBody Mascota mascota) {
        return ResponseEntity.ok(service.actualizar(id, mascota));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una mascota")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
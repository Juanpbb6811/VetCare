package com.vetcare.grupo_3.Controller;

import com.vetcare.grupo_3.Entity.Cita;
import com.vetcare.grupo_3.Service.citaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cita")
@AllArgsConstructor
public class citaController {
    private final citaService citaService;

    //listar citas
    @GetMapping
    public ResponseEntity<List<Cita>> listarTodas() {
        return ResponseEntity.ok(citaService.listarCitas());
    }

    // Buscar cita por id
    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.BuscarPorId(id));
    }

    // Crear cita
    @PostMapping
    public ResponseEntity<Cita> guardar(@RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.registrar(cita));
    }


}

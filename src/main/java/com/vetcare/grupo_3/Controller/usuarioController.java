package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.DTO.responseDTO.usuarioResponseDTO;
import com.vetcare.grupo_3.DTO.usuarioDTO;
import com.vetcare.grupo_3.Service.usuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class usuarioController {

    private final usuarioService service;



    @GetMapping
    public ResponseEntity<List<usuarioResponseDTO>> listar() {
        return ResponseEntity.ok(service.ListarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<usuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.BuscarUsuarioId(id));
    }

    @PostMapping
    public ResponseEntity<usuarioResponseDTO> guardar(@Valid @RequestBody usuarioDTO dto) {
        return new ResponseEntity<>(service.guardarUsuario(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<usuarioResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody usuarioDTO dto) {
        return ResponseEntity.ok(service.actualizarUsuario(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id_usuario}/rol/{rol_id}")
    public ResponseEntity<usuarioResponseDTO> asignarRol(@PathVariable Long id_usuario, @PathVariable Long rol_id) {
        return ResponseEntity.ok(service.asignarRol(id_usuario, rol_id));
    }

    @PostMapping("/login")
    public ResponseEntity<usuarioResponseDTO> autenticar(@RequestParam String correo, @RequestParam String password) {
        return ResponseEntity.ok(service.autenticar(correo, password));
    }
}
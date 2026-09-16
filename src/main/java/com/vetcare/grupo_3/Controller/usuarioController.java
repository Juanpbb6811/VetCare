package com.vetcare.grupo_3.controller;

import com.vetcare.grupo_3.Entity.Usuario;
import com.vetcare.grupo_3.Service.usuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "API para la gestión y autenticación de usuarios (RF01)")
public class usuarioController {

    private final usuarioService service;

    @GetMapping
    @Operation(summary = "Listar todos los usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(service.ListarUsuarios());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un usuario por su ID")
    public ResponseEntity<Usuario> buscarUsuarioId(@PathVariable Long id) {
        return ResponseEntity.ok(service.BuscarUsuarioId(id));
    }

    @PostMapping("/registro")
    @Operation(summary = "Registrar un nuevo usuario")
    public ResponseEntity<Usuario> guardarUsuario(@Valid @RequestBody Usuario usuario) {
        // El @Valid asegura que se cumplan el @NotBlank y @Email de tu entidad
        return new ResponseEntity<>(service.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario existente")
    public ResponseEntity<Usuario> actualizarUsuario(@Valid @RequestBody Usuario usuario, @PathVariable Long id) {
        return ResponseEntity.ok(service.actualizarUsuario(usuario, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        service.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    @Operation(summary = "Autenticar un usuario (Inicio de sesión)")
    public ResponseEntity<Usuario> login(@RequestBody Map<String, String> credenciales) {
        String correo = credenciales.get("correo");
        String password = credenciales.get("password");
        // Nota: Por ahora tu entidad no tiene campo 'password', pero el servicio recibe el parámetro.
        return ResponseEntity.ok(service.autenticar(correo, password));
    }
}
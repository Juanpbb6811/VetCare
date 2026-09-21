package com.vetcare.grupo_3.DTO.responseDTO;

import com.vetcare.grupo_3.Entity.Usuario;

public record usuarioResponseDTO(
   Long id,
   String nombre,
   String correo,
   String telefono,
   String password,
   Long   rolId
) {}

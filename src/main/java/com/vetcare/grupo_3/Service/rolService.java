package com.vetcare.grupo_3.Service;
import com.vetcare.grupo_3.DTO.responseDTO.rolResponseDTO;
import com.vetcare.grupo_3.DTO.rolDTO;
import com.vetcare.grupo_3.Entity.Rol;
import java.util.List;

public interface rolService {
    List<rolResponseDTO> listarRol();
    rolResponseDTO buscarRolId(Long id);
    rolResponseDTO guardarRol(rolDTO dto);
    rolResponseDTO actualizarRol(rolDTO dto, Long id);
    void eliminarRol(Long id);
}

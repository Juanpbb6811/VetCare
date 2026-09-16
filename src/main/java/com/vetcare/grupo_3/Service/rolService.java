package com.vetcare.grupo_3.Service;
import com.vetcare.grupo_3.Entity.Rol;
import java.util.List;

public interface rolService {
    List<Rol> listarRol();
    Rol buscarRolId(Long id);
    Rol guardarRol(Rol rol);
    Rol actualizarRol(Rol rol, Long id);
    void eliminarRol(Long id);
}

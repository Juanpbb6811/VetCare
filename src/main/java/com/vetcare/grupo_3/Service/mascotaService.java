package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.Entity.Mascota;

import java.util.List;

public interface mascotaService {
    List<Mascota> ListarMascotas();

    Mascota BuscarporId(Long id);

    Mascota crear(Mascota mascota, Long usuarioId);

    Mascota actualizar(Long id, Mascota mascota);

    void eliminar(Long id);
}

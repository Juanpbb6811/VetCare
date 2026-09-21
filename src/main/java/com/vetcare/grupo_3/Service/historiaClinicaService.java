package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.Entity.HistoriaClinica;

public interface historiaClinicaService {
    HistoriaClinica BuscarHistoriaClinicaPorMascotaId(Long mascotaId);
    HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica, Long mascotaId);
    HistoriaClinica actualizarHistoriaClinica(HistoriaClinica historiaClinica, Long mascotaId);
    HistoriaClinica eliminarHistoriaClinica(Long id);



}

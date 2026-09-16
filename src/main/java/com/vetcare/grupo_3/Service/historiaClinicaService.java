package com.vetcare.grupo_3.Service;

import com.vetcare.grupo_3.Entity.HistoriaClinica;

import java.util.List;

public interface historiaClinicaService {
    HistoriaClinica BuscarHistoriaClinicaPorMascotaId(Long mascotaId);
    HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica, Long mascotaId);



}

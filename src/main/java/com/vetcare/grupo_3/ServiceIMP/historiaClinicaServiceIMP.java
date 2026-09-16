package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.HistoriaClinica;
import com.vetcare.grupo_3.Entity.Mascota;
import com.vetcare.grupo_3.Repository.historiaClinicaRepository;
import com.vetcare.grupo_3.Repository.mascotaRepository;
import com.vetcare.grupo_3.Service.historiaClinicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class historiaClinicaServiceIMP implements historiaClinicaService {
    private final historiaClinicaRepository historiaClinicaRepository;
    private final mascotaRepository mascotaRepository;

    @Override
    public HistoriaClinica BuscarHistoriaClinicaPorMascotaId(Long mascotaId) {
        mascotaRepository.findById(mascotaId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Mascota no encontrada"));

        return historiaClinicaRepository.findByMascotaId(mascotaId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Historia clínica no encontrada"));
    }

    @Override
    @Transactional
    public HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica, Long mascotaId) {

        Mascota mascota = mascotaRepository
                .findById(mascotaId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Mascota no encontrada"));

        return historiaClinicaRepository.save(historiaClinica);
    }
}



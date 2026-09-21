package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.HistoriaClinica;
import com.vetcare.grupo_3.Entity.Mascota;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
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
        Mascota mascota = mascotaRepository.findById(mascotaId)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada con ID: " + mascotaId));

        if (mascota.getHistoriaclinica() == null) {
            throw new ResourceNotFoundException("Historia clínica no encontrada para la mascota con ID: " + mascotaId);
        }
        return mascota.getHistoriaclinica();
    }

    @Override
    @Transactional
    public HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica, Long mascotaId) {
        Mascota mascota = mascotaRepository.findById(mascotaId)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada con ID: " + mascotaId));
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public HistoriaClinica actualizarHistoriaClinica(HistoriaClinica historiaClinica, Long mascotaId) {

    }

    @Override
    public HistoriaClinica eliminarHistoriaClinica(Long id) {
        return null;
    }
}



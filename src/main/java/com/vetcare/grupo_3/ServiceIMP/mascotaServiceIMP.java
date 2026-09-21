package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.Mascota;
import com.vetcare.grupo_3.Exception.ResourceNotFoundException;
import com.vetcare.grupo_3.Repository.mascotaRepository;
import com.vetcare.grupo_3.Repository.usuarioRepository;
import com.vetcare.grupo_3.Service.mascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class mascotaServiceIMP implements mascotaService {

    private final mascotaRepository mascotaRepository;
    private final usuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> ListarMascotas()
    {
        return mascotaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Mascota BuscarporId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mascota no encontrada con el id " + id));
    }

    @Override
    @Transactional
    public Mascota crear(Mascota mascota, Long usuarioId) {

        usuarioRepository.findById(usuarioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuario no encontrado"));

        return mascotaRepository.save(mascota);
    }

    @Override
    @Transactional
    public Mascota actualizar(Long id, Mascota mascota) {
        Mascota exist = BuscarporId(id);
        return mascotaRepository.save(mascota);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        BuscarporId(id);
        mascotaRepository.deleteById(id);
    }
}
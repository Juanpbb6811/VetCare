package com.vetcare.grupo_3.ServiceIMP;

import com.vetcare.grupo_3.Entity.Rol;
import com.vetcare.grupo_3.Repository.rolRepository;
import com.vetcare.grupo_3.Service.rolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class rolServiceIMP implements rolService {
    private final rolRepository rolRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Rol> listarRol() {
        return rolRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Rol buscarRolId(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Rol no encontrado"));
    }

    @Override
    @Transactional
    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    @Transactional
    public Rol actualizarRol(Rol rol, Long id) {
        Rol existente = buscarRolId(id);
        return rolRepository.save(existente);
    }

    @Override
    @Transactional
    public void eliminarRol(Long id) {
        Rol rol = buscarRolId(id);
        rolRepository.deleteById(id);
    }
}

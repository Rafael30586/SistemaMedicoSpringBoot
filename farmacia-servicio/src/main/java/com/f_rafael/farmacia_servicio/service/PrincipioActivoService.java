package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.repository.IPrincipioActivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrincipioActivoService implements IPrincipioActivoService{

    private IPrincipioActivoRepository repository;
    @Override
    public Optional<PrincipioActivo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PrincipioActivo> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public PrincipioActivo guardar(PrincipioActivo principioActivo) {
        return repository.save(principioActivo);
    }

    @Override
    public PrincipioActivo actualizar(PrincipioActivo principioActivo) {
        return this.guardar(principioActivo);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }
}

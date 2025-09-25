package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.model.Direccion;
import com.f_rafael.lugares_servicio.repository.IDireccionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DireccionService implements IDireccionService{

    private IDireccionRepository repository;

    @Override
    public Optional<Direccion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Direccion> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Direccion guardar(Direccion direccion) {
        return repository.save(direccion);
    }

    @Override
    public Direccion actualizar(Direccion direccion) {
        return this.guardar(direccion);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }
}

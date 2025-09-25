package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.model.Localidad;
import com.f_rafael.lugares_servicio.repository.ILocalidadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocalidadService implements ILocalidadService{

    private ILocalidadRepository repository;

    @Override
    public Optional<Localidad> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Localidad> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Localidad guardar(Localidad localidad) {
        return repository.save(localidad);
    }

    @Override
    public Localidad actualizar(Localidad localidad) {
        return this.guardar(localidad);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }
}

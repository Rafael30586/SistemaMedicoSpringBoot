package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;
import com.f_rafael.farmacia_servicio.repository.IUnidadDeMedidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadDeMedidaService implements IUnidadDeMedidaService{

    private IUnidadDeMedidaRepository repository;
    @Override
    public Optional<UnidadDeMedida> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<UnidadDeMedida> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public UnidadDeMedida guardar(UnidadDeMedida unidad) {
        return repository.save(unidad);
    }

    @Override
    public UnidadDeMedida actualizar(UnidadDeMedida unidad) {
        return this.guardar(unidad);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UnidadDeMedida> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public Optional<UnidadDeMedida> buscarPorSimbolo(String simbolo) {
        return repository.findBySimbolo(simbolo);
    }
}

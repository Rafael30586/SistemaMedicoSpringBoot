package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.repository.IFormaFarmaceuticaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaFarmaceuticaService implements IFormaFarmaceuticaService{

    private IFormaFarmaceuticaRepository repository;

    @Override
    public Optional<FormaFarmaceutica> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<FormaFarmaceutica> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public FormaFarmaceutica guardar(FormaFarmaceutica formaFarmaceutica) {
        return repository.save(formaFarmaceutica);
    }

    @Override
    public FormaFarmaceutica actualizar(FormaFarmaceutica formaFarmaceutica) {
        return this.guardar(formaFarmaceutica);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<FormaFarmaceutica> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }
}

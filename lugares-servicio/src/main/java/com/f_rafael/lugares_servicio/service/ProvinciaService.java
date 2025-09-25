package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.model.Provincia;
import com.f_rafael.lugares_servicio.repository.IProvinciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProvinciaService implements IProvinciaService{

    private IProvinciaRepository repository;

    @Override
    public Optional<Provincia> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Provincia> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Provincia guardar(Provincia provincia) {
        return repository.save(provincia);
    }

    @Override
    public Provincia actualizar(Provincia provincia) {
        return this.guardar(provincia);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }
}

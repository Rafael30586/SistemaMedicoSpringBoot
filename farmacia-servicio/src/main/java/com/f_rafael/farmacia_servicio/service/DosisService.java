package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.Dosis;
import com.f_rafael.farmacia_servicio.repository.IDosisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DosisService implements IDosisService{

    private IDosisRepository repository;

    @Override
    public Optional<Dosis> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Dosis> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Dosis guardar(Dosis dosis) {
        return repository.save(dosis);
    }

    @Override
    public Dosis actualizar(Dosis dosis) {
        return this.guardar(dosis);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }
}

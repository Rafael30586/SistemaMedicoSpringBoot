package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.repository.IAccionTerapeuticaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccionTerapeuticaService implements IAccionTerapeuticaService{

    private IAccionTerapeuticaRepository repository;

    @Override
    public Optional<AccionTerapeutica> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AccionTerapeutica> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public AccionTerapeutica guardar(AccionTerapeutica accionTerapeutica) {
        return repository.save(accionTerapeutica);
    }

    @Override
    public AccionTerapeutica actualizar(AccionTerapeutica accionTerapeutica) {
        return this.guardar(accionTerapeutica);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }
}

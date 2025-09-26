package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.repository.IMarcaMedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaMedicamentoService implements IMarcaMedicamentoService{

    private IMarcaMedicamentoRepository repository;

    @Override
    public Optional<MarcaMedicamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<MarcaMedicamento> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public MarcaMedicamento guardar(MarcaMedicamento marca) {
        return repository.save(marca);
    }

    @Override
    public MarcaMedicamento actualizar(MarcaMedicamento marca) {
        return this.guardar(marca);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }
}

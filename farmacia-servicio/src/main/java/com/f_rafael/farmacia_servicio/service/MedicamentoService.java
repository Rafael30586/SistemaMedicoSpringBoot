package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.repository.IMedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService implements IMedicamentoService{

    private IMedicamentoRepository repository;

    @Override
    public Optional<Medicamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Medicamento> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    @Override
    public Medicamento actualizar(Medicamento medicamento) {
        return this.guardar(medicamento);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }
}

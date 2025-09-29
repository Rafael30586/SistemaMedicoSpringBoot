package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
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
    public List<Medicamento> buscarTodos() {
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

    @Override
    public List<Medicamento> buscarPorPrincipioActivo(String nombrePrincipioActivo) {
        return repository.buscarPorPrincipioActivo(nombrePrincipioActivo);
    }

    @Override
    public List<Medicamento> buscarPorFormaFarmaceutica(String nombreFormaFarmaceutica) {
        return repository.buscarPorFormaFarmaceutica(nombreFormaFarmaceutica);
    }

    @Override
    public List<Medicamento> buscarPorAdministracion(String via) {
        return repository.buscarPorAdministracion(via);
    }

    @Override
    public List<Medicamento> buscarPorMarca(String nombreMarca) {
        return repository.buscarPorMarca(nombreMarca);
    }
}

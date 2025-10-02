package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
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
    public Dosis buscarPorId2(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findById(id).get();
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
    public Dosis actualizar2(Dosis dosis) {
        Long id = dosis.getId();

        if(id == null || dosis.getCantidad() == null || dosis.getUnidad() == null || dosis.getIntervaloHoras() == null){
            throw new CampoNuloException("Ningún campo puede ser nulo");
        }

        return this.guardar(dosis);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public Optional<Dosis> buscarPorCantidadUnidadEIntervalo(float cantidad, String nombreUnidad, int intervalo) {
        return repository.buscarPorCantidadUnidadEIntervalo(cantidad,nombreUnidad,intervalo);
    }

    @Override
    public Dosis buscarPorCantidadUnidadEIntervalo2(float cantidad, String nombreUnidad, int intervalo) {

        if(repository.buscarPorCantidadUnidadEIntervalo(cantidad,nombreUnidad,intervalo).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.buscarPorCantidadUnidadEIntervalo(cantidad,nombreUnidad,intervalo).get();
    }
}

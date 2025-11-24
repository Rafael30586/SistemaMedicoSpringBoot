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
    public Dosis buscarPorId(Long id) {
        return devolverPorId(id);
    }

    @Override
    public List<Dosis> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Dosis guardar(Dosis dosis) {

        if(dosis.getCantidad() == null || dosis.getUnidad() == null || dosis.getIntervaloHoras() == null){
            throw new CampoNuloException("Hay tres campos en esta entidad que no pueden ser nulos");
        }

        return repository.save(dosis);
    }

    @Override
    public Dosis actualizar(Dosis dosis) {
        Long id = dosis.getId();

        if(id == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar(dosis);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public Dosis buscarPorCantidadUnidadEIntervalo(float cantidad, String nombreUnidad, int intervalo) {

        if(repository.buscarPorCantidadUnidadEIntervalo(cantidad,nombreUnidad,intervalo).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.buscarPorCantidadUnidadEIntervalo(cantidad,nombreUnidad,intervalo).get();
    }

    public Dosis devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Dosis no encontrada"));
    }
}

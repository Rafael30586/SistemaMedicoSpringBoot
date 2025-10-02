package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;
import com.f_rafael.farmacia_servicio.repository.IUnidadDeMedidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadDeMedidaService implements IUnidadDeMedidaService{

    private IUnidadDeMedidaRepository repository;

    @Override
    public UnidadDeMedida buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findById(id).get();
    }

    @Override
    public List<UnidadDeMedida> buscarTodas() {
        return repository.findAll();
    }


    @Override
    public UnidadDeMedida guardar(UnidadDeMedida unidad) {

        if(unidad.getNombre() == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        return repository.save(unidad);
    }

    @Override
    public UnidadDeMedida actualizar(UnidadDeMedida unidad) {
        Long id = unidad.getId();

        if(id == null || unidad.getNombre() == null){
            throw new CampoNuloException("Ni el id y ni el nombre pueden ser nulos");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return guardar(unidad);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public UnidadDeMedida buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw  new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findByNombre(nombre).get();
    }

    @Override
    public UnidadDeMedida buscarPorSimbolo(String simbolo) {

        if(repository.findBySimbolo(simbolo).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findBySimbolo(simbolo).get();
    }
}

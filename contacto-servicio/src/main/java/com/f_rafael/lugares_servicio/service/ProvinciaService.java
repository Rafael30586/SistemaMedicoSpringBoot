package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.exception.CampoNuloException;
import com.f_rafael.lugares_servicio.exception.EntidadNoEncontradaException;
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
    public Provincia buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findById(id).get();
    }

    @Override
    public List<Provincia> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Provincia guardar(Provincia provincia) {

        if(provincia.getNombre() == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        return repository.save(provincia);
    }

    @Override
    public Provincia actualizar(Provincia provincia) {
        Long id = provincia.getId();

        if(id == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar(provincia);
    }

    @Override
    public void borrarPorId(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public Provincia buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findByNombre(nombre).get();
    }
}

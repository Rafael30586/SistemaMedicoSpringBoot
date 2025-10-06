package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.exception.CampoNuloException;
import com.f_rafael.lugares_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.lugares_servicio.model.Pais;
import com.f_rafael.lugares_servicio.repository.IPaisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaisService implements IPaisService{

    private IPaisRepository repository;
    @Override
    public Pais buscarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findById(id).get();
    }

    @Override
    public List<Pais> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Pais guardar(Pais pais) {

        if(pais.getNombre() == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        return repository.save(pais);
    }

    @Override
    public Pais actualizar(Pais pais) {

        if(pais.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        return this.guardar(pais);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public Pais buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findByNombre(nombre).get();
    }
}

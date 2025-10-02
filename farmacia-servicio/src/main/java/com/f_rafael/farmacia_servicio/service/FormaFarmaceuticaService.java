package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.FormaFarmaceuticaDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.repository.IFormaFarmaceuticaRepository;
import com.f_rafael.farmacia_servicio.utils.TransformacionFormaFarmaceutica;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaFarmaceuticaService implements IFormaFarmaceuticaService{

    private IFormaFarmaceuticaRepository repository;

    @Override
    public FormaFarmaceuticaDto buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionFormaFarmaceutica.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<FormaFarmaceuticaDto> buscarTodas() {
        return TransformacionFormaFarmaceutica.obtenerListaDtos(repository.findAll());
    }

    @Override
    public FormaFarmaceuticaDto guardar(FormaFarmaceutica formaFarmaceutica) {

        if(formaFarmaceutica.getNombre() == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        return TransformacionFormaFarmaceutica.obtenerDto(repository.save(formaFarmaceutica));
    }

    @Override
    public FormaFarmaceuticaDto actualizar(FormaFarmaceutica formaFarmaceutica) {
        Long id = formaFarmaceutica.getId();

        if(id == null || formaFarmaceutica.getNombre() == null){
            throw new CampoNuloException("El id y el nombre no pueden ser nulos");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar(formaFarmaceutica);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public FormaFarmaceuticaDto buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionFormaFarmaceutica.obtenerDto(repository.findByNombre(nombre).get());
    }
}

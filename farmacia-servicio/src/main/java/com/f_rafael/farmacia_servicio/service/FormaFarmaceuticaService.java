package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.FormaFarmaceuticaDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.repository.IFormaFarmaceuticaRepository;
import com.f_rafael.farmacia_servicio.utils.TransformacionFormaFarmaceutica;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaFarmaceuticaService implements IFormaFarmaceuticaService{

    private IFormaFarmaceuticaRepository repository;

    @Override
    public Optional<FormaFarmaceutica> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public FormaFarmaceuticaDto buscarPorId2(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionFormaFarmaceutica.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<FormaFarmaceutica> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public List<FormaFarmaceuticaDto> buscarTodas2() {
        return TransformacionFormaFarmaceutica.obtenerListaDtos(repository.findAll());
    }

    @Override
    public FormaFarmaceutica guardar(FormaFarmaceutica formaFarmaceutica) {
        return repository.save(formaFarmaceutica);
    }

    @Override
    public FormaFarmaceuticaDto guardar2(FormaFarmaceutica formaFarmaceutica) {

        if(formaFarmaceutica.getNombre() == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        return TransformacionFormaFarmaceutica.obtenerDto(repository.save(formaFarmaceutica));
    }

    @Override
    public FormaFarmaceutica actualizar(FormaFarmaceutica formaFarmaceutica) {
        return this.guardar(formaFarmaceutica);
    }

    @Override
    public FormaFarmaceuticaDto actualizar2(FormaFarmaceutica formaFarmaceutica) {
        Long id = formaFarmaceutica.getId();

        if(id == null || formaFarmaceutica.getNombre() == null){
            throw new CampoNuloException("El id y el nombre no pueden ser nulos");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar2(formaFarmaceutica);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void borrarPorId2(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public Optional<FormaFarmaceutica> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public FormaFarmaceuticaDto buscarPorNombre2(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionFormaFarmaceutica.obtenerDto(repository.findByNombre(nombre).get());
    }
}

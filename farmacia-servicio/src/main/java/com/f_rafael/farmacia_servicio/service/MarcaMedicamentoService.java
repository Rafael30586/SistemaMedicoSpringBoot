package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.repository.IMarcaMedicamentoRepository;
import com.f_rafael.farmacia_servicio.utils.TransformacionMarcaMedicamento;
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
    public MarcaMedicamentoDto buscarPorId2(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionMarcaMedicamento.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<MarcaMedicamento> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public List<MarcaMedicamentoDto> buscarTodas2() {
        return TransformacionMarcaMedicamento.obtenerListaDtos(repository.findAll());
    }

    @Override
    public MarcaMedicamento guardar(MarcaMedicamento marca) {
        return repository.save(marca);
    }

    @Override
    public MarcaMedicamentoDto guardar2(MarcaMedicamento marca) {
        return TransformacionMarcaMedicamento.obtenerDto(repository.save(marca));
    }

    @Override
    public MarcaMedicamento actualizar(MarcaMedicamento marca) {
        return this.guardar(marca);
    }

    @Override
    public MarcaMedicamentoDto actualizar2(MarcaMedicamento marca) {
        Long id = marca.getId();

        if(id == null || marca.getNombre() == null){
            throw new CampoNuloException("El id y el nombre no pueden ser nulos");
        }

        return this.guardar2(marca);
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
    public Optional<MarcaMedicamento> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public MarcaMedicamentoDto buscarPorNombre2(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionMarcaMedicamento.obtenerDto(repository.findByNombre(nombre).get());
    }
}

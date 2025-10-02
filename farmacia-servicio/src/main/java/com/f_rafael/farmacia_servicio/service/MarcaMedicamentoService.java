package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.repository.IMarcaMedicamentoRepository;
import com.f_rafael.farmacia_servicio.utils.TransformacionMarcaMedicamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaMedicamentoService implements IMarcaMedicamentoService{

    private IMarcaMedicamentoRepository repository;

    @Override
    public MarcaMedicamentoDto buscarPorId(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionMarcaMedicamento.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<MarcaMedicamentoDto> buscarTodas() {
        return TransformacionMarcaMedicamento.obtenerListaDtos(repository.findAll());
    }


    @Override
    public MarcaMedicamentoDto guardar(MarcaMedicamento marca) {
        return TransformacionMarcaMedicamento.obtenerDto(repository.save(marca));
    }

    @Override
    public MarcaMedicamentoDto actualizar(MarcaMedicamento marca) {
        Long id = marca.getId();

        if(id == null || marca.getNombre() == null){
            throw new CampoNuloException("El id y el nombre no pueden ser nulos");
        }

        return this.guardar(marca);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public MarcaMedicamentoDto buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionMarcaMedicamento.obtenerDto(repository.findByNombre(nombre).get());
    }
}

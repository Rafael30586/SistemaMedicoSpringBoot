package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.SedeDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.Sede;
import com.f_rafael.pacientes_servicio.repository.ISedeRepository;
import com.f_rafael.pacientes_servicio.utils.SedeMap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SedeService implements ISedeService{

    private ISedeRepository repository;
    private SedeMap tranformacion;

    @Override
    public SedeDto buscarPorId(Long id) {
        SedeDto dtoARetornar;

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        dtoARetornar = tranformacion.obtenerDto(repository.findById(id).get());
        return dtoARetornar;
    }

    @Override
    public List<SedeDto> buscarTodas() {
        List<SedeDto> listaARetornar = tranformacion.obtenerListaDtos(repository.findAll());
        return listaARetornar;
    }

    @Override
    public SedeDto guardar(Sede sede) {
        SedeDto dtoARetornar;

        if(sede.getDireccionId() == null){ // ¿Cómo podría hacer para confirmar que la direccion existe si está en otro microservicio?
            throw new CampoNuloException("La direccion no puede ser nula");
        }

        dtoARetornar = tranformacion.obtenerDto(repository.save(sede));
        return dtoARetornar;
    }

    @Override
    public SedeDto actualizar(Sede sede) {

        if(sede.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }
        return this.guardar(sede);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }
}

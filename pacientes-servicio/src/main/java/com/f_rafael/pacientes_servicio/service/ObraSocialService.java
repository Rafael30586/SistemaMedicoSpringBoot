package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.ObraSocialDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.ObraSocial2;
import com.f_rafael.pacientes_servicio.repository.IObraSocialRepository;
import com.f_rafael.pacientes_servicio.utils.TransformacionObraSocial;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ObraSocialService implements IObraSocialService{

    private TransformacionObraSocial transformacion;

    private IObraSocialRepository repository;
    @Override
    public ObraSocialDto buscarPorId(Long id) {
        ObraSocialDto dtoARetornar;

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        dtoARetornar = transformacion.obtenerDto(repository.findById(id).get());
        return dtoARetornar;
    }

    @Override
    public List<ObraSocialDto> buscarTodas() {
        List<ObraSocialDto> listaARetornar = transformacion.obtenerListaDto(repository.findAll());

        return listaARetornar;
    }

    @Override
    public ObraSocialDto buscarPorNombre(String nombre) {
        ObraSocialDto dtoaRetornar;

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        dtoaRetornar = transformacion.obtenerDto(repository.findByNombre(nombre).get());

        return dtoaRetornar;
    }

    @Override
    public ObraSocialDto guardar(ObraSocial2 obraSocial) {
        ObraSocialDto dtoARetornar;

        if(obraSocial.getNombre() == null){
            throw new CampoNuloException("El nombre no puede se nulo");
        }

        dtoARetornar = transformacion.obtenerDto(repository.save(obraSocial));

        return dtoARetornar;
    }

    @Override
    public ObraSocialDto actualizar(ObraSocial2 obraSocial) {
        if(obraSocial.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }
        return this.guardar(obraSocial);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

}

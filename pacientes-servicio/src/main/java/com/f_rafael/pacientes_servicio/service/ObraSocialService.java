package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.ObraSocialDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.ObraSocial;
import com.f_rafael.pacientes_servicio.model.ObraSocial2;
import com.f_rafael.pacientes_servicio.model.Sede;
import com.f_rafael.pacientes_servicio.repository.IObraSocialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ObraSocialService implements IObraSocialService{

    private IObraSocialRepository repository;
    @Override
    public ObraSocial buscarPorId(Long id) {
        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }
        return repository.findById(id).get();
    }

    @Override
    public List<ObraSocial> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public ObraSocial buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findByNombre(nombre).get();
    }

    @Override
    public ObraSocial guardar(ObraSocial obraSocial) {

        if(obraSocial.getNombre() == null){
            throw new CampoNuloException("El nombre no puede se nulo");
        }

        return repository.save(obraSocial);
    }

    @Override
    public ObraSocial actualizar(ObraSocial obraSocial) {
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

    public ObraSocialDto obtenerDto(ObraSocial2 obraSocial){
        ObraSocialDto dtoARetornar;
        Set<Sede> informacionSedes;

        if(obraSocial.getSedes()!=null){
            informacionSedes = obraSocial.getSedes();
        }
        // falta completar
    }
}

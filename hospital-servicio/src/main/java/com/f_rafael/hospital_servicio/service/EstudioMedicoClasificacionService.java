package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.model.EstudioMedicoClasificacion;
import com.f_rafael.hospital_servicio.repository.IEstudioMedicoClasificacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstudioMedicoClasificacionService implements IEstudioMedicoClasificacionService{

    private IEstudioMedicoClasificacionRepository repository;

    @Override
    public EstudioMedicoClasificacion buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Clasificación de estudio médico no enontrada"));
    }

    @Override
    public List<EstudioMedicoClasificacion> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public EstudioMedicoClasificacion guardar(EstudioMedicoClasificacion clasificacion) {

        if(clasificacion.getNombre() == null){
            throw new CampoNuloException("La clasificación de estudio médico debe tener nombre");
        }

        return repository.save(clasificacion);
    }

    @Override
    public EstudioMedicoClasificacion actualizar(EstudioMedicoClasificacion clasificacion) {

        if(clasificacion.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }

        return this.guardar(clasificacion);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("La clasificación de estudio no ha sido encontrada");
        }

        repository.deleteById(id);
    }
}

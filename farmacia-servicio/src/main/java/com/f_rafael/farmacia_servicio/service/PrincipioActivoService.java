package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.PrincipioActivoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.repository.IPrincipioActivoRepository;
import com.f_rafael.farmacia_servicio.utils.TransformacionPrincipioActivo;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class PrincipioActivoService implements IPrincipioActivoService{

    private IPrincipioActivoRepository repository;

    @Override
    public PrincipioActivoDto buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionPrincipioActivo.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<PrincipioActivoDto> buscarTodos() {
        return TransformacionPrincipioActivo.obtenerListaDto(repository.findAll());
    }

    @Override
    public PrincipioActivoDto guardar(PrincipioActivo principioActivo) {
        if(principioActivo.getNombre() == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        return TransformacionPrincipioActivo.obtenerDto(repository.save(principioActivo));
    }


    @Override
    public PrincipioActivoDto actualizar(PrincipioActivo principioActivo) {
        Long id = principioActivo.getId();

        if(id == null){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar(principioActivo);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<PrincipioActivoDto> buscarPorAccionTerapeutica(String nombreAccionTerapeutica) {
        List<PrincipioActivo> principiosActivosARetornar = new LinkedList<>();
        List<PrincipioActivo> todosLosPrincipiosActivos = repository.findAll();
        Set<AccionTerapeutica> accionesTerapeuticas;
        boolean tieneLaAccionTerapeutica;

        for(PrincipioActivo pa : todosLosPrincipiosActivos){
            tieneLaAccionTerapeutica = false;

            accionesTerapeuticas = pa.getAccionesTerapeuticas();
/*
            accionesTerapeuticas.stream().parallel().forEach(at -> {
                if(at.getNombre().equals(nombreAccionTerapeutica)) tieneLaAccionTerapeutica = true;
            });*/

            for(AccionTerapeutica at : accionesTerapeuticas){
                if(at.getNombre().equals(nombreAccionTerapeutica)) tieneLaAccionTerapeutica = true;
            }

            if(tieneLaAccionTerapeutica) principiosActivosARetornar.add(pa);
        }

        return TransformacionPrincipioActivo.obtenerListaDto(principiosActivosARetornar);
    }
}

package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.repository.IPrincipioActivoRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PrincipioActivoService implements IPrincipioActivoService{

    private IPrincipioActivoRepository repository;
    @Override
    public Optional<PrincipioActivo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PrincipioActivo> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public PrincipioActivo guardar(PrincipioActivo principioActivo) {
        return repository.save(principioActivo);
    }

    @Override
    public PrincipioActivo actualizar(PrincipioActivo principioActivo) {
        return this.guardar(principioActivo);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<PrincipioActivo> buscarPorAccionTerapeutica(String nombreAccionTerapeutica) {
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

        return principiosActivosARetornar;
    }
}

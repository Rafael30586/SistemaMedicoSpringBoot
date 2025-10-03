package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.exception.CampoNuloException;
import com.f_rafael.lugares_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.lugares_servicio.model.Direccion;
import com.f_rafael.lugares_servicio.repository.IDireccionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DireccionService implements IDireccionService{

    private IDireccionRepository repository;

    @Override
    public Direccion buscarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findById(id).get();
    }

    @Override
    public List<Direccion> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Direccion guardar(Direccion direccion) {

        if(direccion.getCalle() == null){
            throw new CampoNuloException("La calle no puede ser nula");
        }

        return repository.save(direccion);
    }

    @Override
    public Direccion actualizar(Direccion direccion) {

        if(direccion.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        return this.guardar(direccion);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<Direccion> buscarPorLocalidad(String localidad) {
        List<Direccion> todasLasDirecciones = repository.findAll();
        List<Direccion> direccionesARetornar = new LinkedList<>();

        todasLasDirecciones.stream().parallel().forEach(direccion -> {
            if(direccion.getLocalidad().getNombre().equals(localidad)){
                direccionesARetornar.add(direccion);
            }
        });

        return direccionesARetornar;
    }

    @Override
    public List<Direccion> buscarPorProvincia(String provincia) {
        List<Direccion> todasLasDirecciones = repository.findAll();
        List<Direccion> direccionesARetornar = new LinkedList<>();

        todasLasDirecciones.stream().parallel().forEach(direccion -> {
            if(direccion.getLocalidad().getProvincia().getNombre().equals(provincia)){
                direccionesARetornar.add(direccion);
            }
        });

        return direccionesARetornar;
    }

    @Override
    public void editarCalle(Long id, String calle) {
        Direccion direccionAEditar;

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        direccionAEditar = repository.findById(id).get();
        direccionAEditar.setCalle(calle);

        this.guardar(direccionAEditar);
    }

    @Override
    public void editarAltura(Long id, Integer altura) {
        Direccion direccionAEditar;

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        direccionAEditar = repository.findById(id).get();
        direccionAEditar.setAltura(altura);

        this.guardar(direccionAEditar);
    }

    @Override
    public void editarDepartamento(Long id, String departamento) {
        Direccion direccionAEditar;

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        direccionAEditar = repository.findById(id).get();
        direccionAEditar.setDepartamento(departamento);

        this.guardar(direccionAEditar);
    }
}

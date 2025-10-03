package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.exception.CampoNuloException;
import com.f_rafael.lugares_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.lugares_servicio.model.Localidad;
import com.f_rafael.lugares_servicio.model.Provincia;
import com.f_rafael.lugares_servicio.repository.ILocalidadRepository;
import com.f_rafael.lugares_servicio.repository.IProvinciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocalidadService implements ILocalidadService{

    private ILocalidadRepository repository;
    private IProvinciaRepository provinciaRepository;

    @Override
    public Localidad buscarPorId(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }
        return repository.findById(id).get();
    }

    @Override
    public List<Localidad> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Localidad guardar(Localidad localidad) {

        if(localidad.getNombre() == null || localidad.getProvincia() == null){
            throw new CampoNuloException("Algunos campos no pueden ser nulos");
        }

        return repository.save(localidad);
    }

    @Override
    public Localidad actualizar(Localidad localidad) {

        if(localidad.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        return this.guardar(localidad);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public void cambiarNombre(Long id, String nombre) {
        Localidad localidadAEditar;

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        localidadAEditar = repository.findById(id).get();
        localidadAEditar.setNombre(nombre);

        this.guardar(localidadAEditar);
    }

    @Override
    public void cambiarProvincia(Long id, Long idProvincia) {
        Provincia provinciaParaAsignar;
        Localidad localidadAEditar;

        if(repository.findById(id).isEmpty() || provinciaRepository.findById(idProvincia).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        provinciaParaAsignar = new Provincia();
        provinciaParaAsignar.setId(idProvincia);

        localidadAEditar = repository.findById(id).get();
        localidadAEditar.setProvincia(provinciaParaAsignar);

        repository.save(localidadAEditar);
    }
}

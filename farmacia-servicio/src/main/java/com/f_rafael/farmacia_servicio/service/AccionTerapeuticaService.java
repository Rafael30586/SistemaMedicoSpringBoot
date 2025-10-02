package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.repository.IAccionTerapeuticaRepository;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
import com.f_rafael.farmacia_servicio.utils.TransformacionAccionTerapeutica;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccionTerapeuticaService implements IAccionTerapeuticaService{

    private IAccionTerapeuticaRepository repository;

    @Override
    public Optional<AccionTerapeutica> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public AccionTerapeuticaDto buscartPorId2(Long id) {
        AccionTerapeutica informacionAccionTerapeutica;
        AccionTerapeuticaDto dtoARetornar;

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        informacionAccionTerapeutica = repository.findById(id).get();
        dtoARetornar = TransformacionAccionTerapeutica.obtenerDto(informacionAccionTerapeutica);
        return dtoARetornar;
    }

    @Override
    public List<AccionTerapeutica> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public AccionTerapeutica guardar(AccionTerapeutica accionTerapeutica) {
        return repository.save(accionTerapeutica);
    }

    @Override
    public AccionTerapeuticaDto guardar2(AccionTerapeutica accionTerapeutica) {
        AccionTerapeuticaDto dtoARetornar;

        if(accionTerapeutica.getNombre() == null){
            throw new CampoNuloException("El nombre de la acción terapéutica no puede ser nulo");
        }

        return TransformacionAccionTerapeutica.obtenerDto(repository.save(accionTerapeutica));
    }

    @Override
    public AccionTerapeutica actualizar(AccionTerapeutica accionTerapeutica) {
        return this.guardar(accionTerapeutica);
    }

    @Override
    public AccionTerapeuticaDto actualizar2(AccionTerapeutica accionTerapeutica) {
        Long id = accionTerapeutica.getId();

        if(id == null || accionTerapeutica.getNombre() == null){
            throw new CampoNuloException("El id y el nombre no pueden ser nulos");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("El id no corresponde a ninguna entidad en la base de datos");
        }

        return this.guardar2(accionTerapeutica);
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
    public Optional<AccionTerapeutica> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public AccionTerapeuticaDto buscarPorNombre2(String nombre) {
        AccionTerapeutica informacionAccionTerapeutica;
        AccionTerapeuticaDto dtoARetornar;

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        informacionAccionTerapeutica = repository.findByNombre(nombre).get();
        dtoARetornar = TransformacionAccionTerapeutica.obtenerDto(informacionAccionTerapeutica);
        return dtoARetornar;
    }

    @Override
    public List<AccionTerapeutica> buscarPorSecuenciaEnDescripcion(String secuencia) {
        return repository.findAll();
    }

    @Override
    public List<AccionTerapeuticaDto> buscarPorSecuenciaEnDescripcion2(String secuencia) {
        return TransformacionAccionTerapeutica.obtenerListaDtos(repository.buscarPorSecuenciaEnDescripcion(secuencia));
    }

    @Override
    public void modificarNombre(Long id, String nombre) {
        String nombreSinGuiones = Transformacion.removerGuionesBajos(nombre);
        AccionTerapeutica accionTerapeuticaAEditar;

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        accionTerapeuticaAEditar = repository.findById(id).get();
        accionTerapeuticaAEditar.setNombre(nombreSinGuiones);
        this.actualizar2(accionTerapeuticaAEditar);
    }


}

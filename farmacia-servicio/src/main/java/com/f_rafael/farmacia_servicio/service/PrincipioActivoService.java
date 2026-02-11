package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.PrincipioActivoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.DatoIncorrectoException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.PrincipioActivoMapper;
import com.f_rafael.farmacia_servicio.mapper.StringMapper;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.repository.IAccionTerapeuticaRepository;
import com.f_rafael.farmacia_servicio.repository.IPrincipioActivoRepository;
import com.f_rafael.farmacia_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class PrincipioActivoService implements IPrincipioActivoService{

    private IPrincipioActivoRepository repository;
    private IAccionTerapeuticaRepository accionTerapeuticaRepository;
    private PrincipioActivoMapper mapper;
    private Verificador verificador;
    private StringMapper stringMapper;


    @Override
    public PrincipioActivoDto buscarPorId(Long id) {
        return mapper.obtenerDto(devolverPorId(id));
    }

    @Override
    public List<PrincipioActivoDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public PrincipioActivoDto guardar(PrincipioActivo principioActivo) {
        String nombre = principioActivo.getNombre();
        Set<AccionTerapeutica> accionesTerapeuticas = principioActivo.getAccionesTerapeuticas();

        if(nombre == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        if(accionesTerapeuticas != null){
            for(AccionTerapeutica at : accionesTerapeuticas){
                if(!accionTerapeuticaRepository.existsById(at.getId())){
                    throw new DatoIncorrectoException("El id no corresponde a ninguna acción terapéutica");
                }
            }
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombre);

        return mapper.obtenerDto(repository.save(principioActivo));
    }


    @Override
    public PrincipioActivoDto actualizar(PrincipioActivo principioActivo) {
        Long id = principioActivo.getId();
        String nuevoNombre = principioActivo.getNombre();

        if(id == null){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        if(nuevoNombre != repository.findById(id).get().getNombre()){
            if(existePorNombre(nuevoNombre)) throw new DatoIncorrectoException("El nombre ya existe para otra entidad");
        }

        return this.guardar(principioActivo);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public PrincipioActivoDto buscarPorNombre(String nombre) {

        String nombreSinGuiones = stringMapper.removerGuionesBajos(nombre);

        if(repository.findByNombre(nombreSinGuiones).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findByNombre(nombreSinGuiones).get());
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

            for(AccionTerapeutica at : accionesTerapeuticas){
                if(at.getNombre().equals(nombreAccionTerapeutica)) tieneLaAccionTerapeutica = true;
            }

            if(tieneLaAccionTerapeutica) principiosActivosARetornar.add(pa);
        }

        return mapper.obtenerListaDto(principiosActivosARetornar);
    }

    @Override
    public PrincipioActivoDto modificarNombre(Long id, String nombre) {
        PrincipioActivo principioActivoParaActualizar = devolverPorId(id);
        String nombreSinGuiones = stringMapper.removerGuionesBajos(nombre);

        if(existePorNombre(nombreSinGuiones)){
            throw new DatoIncorrectoException("El nombre ya existe para alguna entidad");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSinGuiones);

        principioActivoParaActualizar.setNombre(nombreSinGuiones);

        return this.actualizar(principioActivoParaActualizar);
    }

    @Override
    public PrincipioActivoDto agregarAccionTerapeutica(Long id, Long accionTerapeuticaId) {
        PrincipioActivo principioActivoAEditar;
        AccionTerapeutica accionTerapeuticaAAgregar;
        Set<AccionTerapeutica> setAccionesTerapeuticas;

        if(repository.findById(id).isEmpty() || accionTerapeuticaRepository.findById(accionTerapeuticaId).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad  no encontrada");
        }

        principioActivoAEditar = repository.findById(id).get();

        accionTerapeuticaAAgregar = new AccionTerapeutica();
        accionTerapeuticaAAgregar.setId(accionTerapeuticaId);

        setAccionesTerapeuticas = principioActivoAEditar.getAccionesTerapeuticas();
        setAccionesTerapeuticas.add(accionTerapeuticaAAgregar);

        principioActivoAEditar.setAccionesTerapeuticas(setAccionesTerapeuticas);

        return this.actualizar(principioActivoAEditar);
    }

    @Override
    public PrincipioActivoDto quitarAccionTerapeutica(Long id, Long accionTerapeuticaId) {
        PrincipioActivo principioActivoAEditar;
        AccionTerapeutica accionTerapeuticaAQuitar;
        Set<AccionTerapeutica> setAccionesTerapeuticas;

        if(repository.findById(id).isEmpty() || accionTerapeuticaRepository.findById(accionTerapeuticaId).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad  no encontrada");
        }

        accionTerapeuticaAQuitar = new AccionTerapeutica();

        principioActivoAEditar = repository.findById(id).get();

        setAccionesTerapeuticas = principioActivoAEditar.getAccionesTerapeuticas();

        for(AccionTerapeutica at : setAccionesTerapeuticas){
            if(at.getId().equals(accionTerapeuticaId)){
                accionTerapeuticaAQuitar = at;
            }
        }

        setAccionesTerapeuticas.remove(accionTerapeuticaAQuitar);
        principioActivoAEditar.setAccionesTerapeuticas(setAccionesTerapeuticas);

        return this.actualizar(principioActivoAEditar);
    }

    private PrincipioActivo devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Principio activo no encontrado"));
    }

    private boolean existePorNombre(String nombre){
        return repository.findByNombre(nombre).isPresent();
    }

}

package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MedicamentoDto;
import com.f_rafael.farmacia_servicio.dto.PrincipioActivoDto;
import com.f_rafael.farmacia_servicio.dto.SubAccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.PrincipioActivoMapper;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;
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

        if(nombre == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombre);

        return mapper.obtenerDto(repository.save(principioActivo));
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

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public PrincipioActivoDto buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findByNombre(nombre).get());
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

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombre);

        principioActivoParaActualizar.setNombre(nombre);

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
        accionTerapeuticaAAgregar.setId(id);

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

    public PrincipioActivo devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Principio activo no encontrado"));
    }

}

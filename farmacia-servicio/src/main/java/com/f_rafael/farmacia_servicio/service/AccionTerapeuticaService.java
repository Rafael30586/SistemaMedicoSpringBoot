package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.DescripcionDto;
import com.f_rafael.farmacia_servicio.dto.SubPrincipioActivoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.AccionTerapeuticaMapper;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.repository.IAccionTerapeuticaRepository;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class AccionTerapeuticaService implements IAccionTerapeuticaService{

    private IAccionTerapeuticaRepository repository;
    private AccionTerapeuticaMapper mapper;


    @Override
    public AccionTerapeuticaDto buscarPorId(Long id) {
        AccionTerapeutica informacionAccionTerapeutica;
        AccionTerapeuticaDto dtoARetornar;

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        informacionAccionTerapeutica = repository.findById(id).get();
        dtoARetornar = mapper.obtenerDto(informacionAccionTerapeutica);
        return dtoARetornar;
    }

    @Override
    public List<AccionTerapeuticaDto> buscarTodas() {
        return obtenerListaDto(repository.findAll());
    }

    @Override
    public AccionTerapeuticaDto guardar(AccionTerapeutica accionTerapeutica) {
        AccionTerapeuticaDto dtoARetornar;

        if(accionTerapeutica.getNombre() == null){
            throw new CampoNuloException("El nombre de la acción terapéutica no puede ser nulo");
        }

        return mapper.obtenerDto(repository.save(accionTerapeutica));
    }


    @Override
    public AccionTerapeuticaDto actualizar(AccionTerapeutica accionTerapeutica) {
        Long id = accionTerapeutica.getId();

        if(id == null || accionTerapeutica.getNombre() == null){
            throw new CampoNuloException("El id y el nombre no pueden ser nulos");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("El id no corresponde a ninguna entidad en la base de datos");
        }

        return this.guardar(accionTerapeutica);
    }


    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public AccionTerapeuticaDto buscarPorNombre(String nombre) {
        AccionTerapeutica informacionAccionTerapeutica;
        AccionTerapeuticaDto dtoARetornar;

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        informacionAccionTerapeutica = repository.findByNombre(nombre).get();
        dtoARetornar = mapper.obtenerDto(informacionAccionTerapeutica);
        return dtoARetornar;
    }



    @Override
    public List<AccionTerapeuticaDto> buscarPorSecuenciaEnDescripcion(String secuencia) {
        return obtenerListaDto(repository.buscarPorSecuenciaEnDescripcion(secuencia));
    }

    @Override
    public AccionTerapeuticaDto modificarNombre(Long id, String nombre) {
        String nombreSinGuiones = Transformacion.removerGuionesBajos(nombre);
        AccionTerapeutica accionTerapeuticaAEditar;

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        accionTerapeuticaAEditar = repository.findById(id).get();
        accionTerapeuticaAEditar.setNombre(nombreSinGuiones);
        return this.actualizar(accionTerapeuticaAEditar);
    }

    @Override
    public AccionTerapeuticaDto modificarDescripcion(Long id, DescripcionDto descripcion) {
        AccionTerapeutica accionTerapeuticaParaActualizar = devolverPorId(id);
        accionTerapeuticaParaActualizar.setDescripcion(descripcion.getTexto());

        return this.actualizar(accionTerapeuticaParaActualizar);
    }

    private AccionTerapeuticaDto obtenerDto(AccionTerapeutica informacionAccionTerapeutica){
        Optional<Set<PrincipioActivo>> principiosActivosOpcional = Optional.of(informacionAccionTerapeutica.getPrincipiosActivos());
        Set<PrincipioActivo> informacionPrincipiosActivos;
        AccionTerapeuticaDto dtoARetornar = new AccionTerapeuticaDto();
        Set<SubPrincipioActivoDto> principiosActivosParaAsignar;
        SubPrincipioActivoDto principioActivoParaAsignar;

        dtoARetornar.setId(informacionAccionTerapeutica.getId());
        dtoARetornar.setNombre(informacionAccionTerapeutica.getNombre());

        if(principiosActivosOpcional.isPresent()){
            informacionPrincipiosActivos = principiosActivosOpcional.get();
            principiosActivosParaAsignar = new HashSet<>();

            for(PrincipioActivo pa : informacionPrincipiosActivos){
                principioActivoParaAsignar = new SubPrincipioActivoDto(pa.getId(), pa.getNombre());
                principiosActivosParaAsignar.add(principioActivoParaAsignar);
            }

            dtoARetornar.setPrincipiosActivos(principiosActivosParaAsignar);
        }
        return dtoARetornar;
    }

    private List<AccionTerapeuticaDto> obtenerListaDto(Collection<AccionTerapeutica> accionesTerapeuticas){

        List<AccionTerapeuticaDto> listaARetornar = new LinkedList<>();
        AccionTerapeuticaDto dtoParaAgregar;

        for(AccionTerapeutica at : accionesTerapeuticas){
            dtoParaAgregar = obtenerDto(at);
            listaARetornar.add(dtoParaAgregar);
        }

        return listaARetornar;
    }

    private AccionTerapeutica devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Acción terapéutica no encontrada"));
    }

}

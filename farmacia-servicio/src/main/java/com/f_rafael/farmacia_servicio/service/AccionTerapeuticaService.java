package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.DescripcionDto;
import com.f_rafael.farmacia_servicio.dto.SubPrincipioActivoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.DatoIncorrectoException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.AccionTerapeuticaMapper;
import com.f_rafael.farmacia_servicio.mapper.StringMapper;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.repository.IAccionTerapeuticaRepository;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
import com.f_rafael.farmacia_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class AccionTerapeuticaService implements IAccionTerapeuticaService{

    private IAccionTerapeuticaRepository repository;
    private AccionTerapeuticaMapper mapper;
    private Verificador verificador;
    private StringMapper stringMapper;


    @Override
    public AccionTerapeuticaDto buscarPorId(Long id) {
        AccionTerapeutica informacionAccionTerapeutica = devolverPorId(id);

        return mapper.obtenerDto(informacionAccionTerapeutica);
    }

    @Override
    public List<AccionTerapeuticaDto> buscarTodas() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public AccionTerapeuticaDto guardar(AccionTerapeutica accionTerapeutica) {
        String nombre = accionTerapeutica.getNombre();

        if(nombre == null){
            throw new CampoNuloException("El nombre de la acción terapéutica no puede ser nulo");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombre);

        return mapper.obtenerDto(repository.save(accionTerapeutica));
    }


    @Override
    public AccionTerapeuticaDto actualizar(AccionTerapeutica accionTerapeutica) {
        Long id = accionTerapeutica.getId();
        String nombre = accionTerapeutica.getNombre();

        if(id == null){
            throw new CampoNuloException("El nombre de la acción terpéutica no puede ser nulo");
        }

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El id no corresponde a ninguna entidad en la base de datos");
        }

        if(nombre != repository.findById(id).get().getNombre()){
            if(existePorNombre(nombre)) throw new DatoIncorrectoException("El nombre ya existe para otra entidad");
        }

        return this.guardar(accionTerapeutica);
    }


    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public AccionTerapeuticaDto buscarPorNombre(String nombre) {
        AccionTerapeutica informacionAccionTerapeutica;
        AccionTerapeuticaDto dtoARetornar;

        if(!existePorNombre(nombre)) throw new EntidadNoEncontradaException("Entidad no encontrada");

        informacionAccionTerapeutica = repository.findByNombre(nombre).get();
        dtoARetornar = mapper.obtenerDto(informacionAccionTerapeutica);
        return dtoARetornar;
    }



    @Override
    public List<AccionTerapeuticaDto> buscarPorSecuenciaEnDescripcion(String secuencia) {
        return mapper.obtenerListaDto(repository.buscarPorSecuenciaEnDescripcion(secuencia));
    }

    @Override
    public AccionTerapeuticaDto modificarNombre(Long id, String nombre) {
        String nombreSinGuiones = stringMapper.removerGuionesBajos(nombre);
        AccionTerapeutica accionTerapeuticaAEditar = devolverPorId(id);

        if(existePorNombre(nombre)){
            throw new DatoIncorrectoException("El nombre est{a presente en otra entidad");
        }

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombreSinGuiones);

        accionTerapeuticaAEditar.setNombre(nombreSinGuiones);

        return this.actualizar(accionTerapeuticaAEditar);
    }

    @Override
    public AccionTerapeuticaDto modificarDescripcion(Long id, DescripcionDto descripcion) {
        AccionTerapeutica accionTerapeuticaParaActualizar = devolverPorId(id);
        accionTerapeuticaParaActualizar.setDescripcion(descripcion.getTexto());

        return this.actualizar(accionTerapeuticaParaActualizar);
    }



    private AccionTerapeutica devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Acción terapéutica no encontrada"));
    }

    private boolean existePorNombre(String nombre){
        return repository.findByNombre(nombre).isPresent();
    }

}

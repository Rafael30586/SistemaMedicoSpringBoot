package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.SedeDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.DatoIncorrectoException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.ObraSocial;
import com.f_rafael.pacientes_servicio.model.Sede;
import com.f_rafael.pacientes_servicio.repository.*;
import com.f_rafael.pacientes_servicio.mapper.SedeMapper;
import com.f_rafael.pacientes_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SedeService implements ISedeService{

    private ISedeRepository repository;
    private SedeMapper mapper;
    // private IDireccionClient direccionClient;
    private IObraSocialRepository obraSocialRepository;
    private Verificador verificador;
    private IContactoClient contactoClient;

    @Override
    public SedeDto buscarPorId(Long id) {
        SedeDto dtoARetornar;

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        dtoARetornar = mapper.obtenerDto(repository.findById(id).get());
        return dtoARetornar;
    }

    @Override
    public List<SedeDto> buscarTodas() {
        List<SedeDto> listaARetornar = mapper.obtenerListaDto(repository.findAll());
        return listaARetornar;
    }

    @Override
    public SedeDto guardar(Sede sede) {
        SedeDto dtoARetornar;
        Set<String> telefonos = sede.getTelefonos();

        if(sede.getDireccionId() == null){ // ¿Cómo podría hacer para confirmar que la direccion existe si está en otro microservicio?
            throw new CampoNuloException("La direccion no puede ser nula");
        }

        telefonos.stream().forEach(verificador::esNumeroTelefonico);

        dtoARetornar = mapper.obtenerDto(repository.save(sede));
        return dtoARetornar;
    }

    @Override
    public SedeDto actualizar(Sede sede) {

        if(sede.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }
        return this.guardar(sede);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<SedeDto> buscarPorDireccion(String calle) {
        List<SedeDto> listaARetornar = new LinkedList<>();
        List<Sede> informacionSedes = repository.findAll();

        for(Sede s : informacionSedes){
            if(contactoClient.obtenerDireccionPorId(s.getDireccionId()).getCalle().equals(calle)){
                listaARetornar.add(mapper.obtenerDto(s));
            }
        }

        return listaARetornar;
    }

    @Override
    public SedeDto buscarPortelefono(String telefono) {
        return mapper.obtenerDto(repository.buscarPorNumeroTelefonico(telefono).orElseThrow(()-> new EntidadNoEncontradaException("Sede no encontrada")));
    }

    @Override
    public SedeDto actualizarDireccion(Long id, Long direccionId) {
        Sede sedeParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sede no encontrada"));
        sedeParaActualizar.setDireccionId(direccionId);

        return this.actualizar(sedeParaActualizar);
    }

    @Override
    public SedeDto agregarTelefono(Long id, String telefono) {
        Sede sedeParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sede no encontrada"));
        Set<String> telefonosParaAsignar = sedeParaActualizar.getTelefonos();

        verificador.esNumeroTelefonico(telefono);

        telefonosParaAsignar.add(telefono);
        sedeParaActualizar.setTelefonos(telefonosParaAsignar);

        return this.actualizar(sedeParaActualizar);
    }

    @Override
    public SedeDto quitarTelefono(Long id, String telefono) {
        Sede sedeParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sede no encontrada"));
        Set<String> telefonosParaAsignar = sedeParaActualizar.getTelefonos();

        if(!telefonosParaAsignar.contains(telefono)){
            throw new DatoIncorrectoException("El número telefónico no se encuentra en la lista");
        }

        telefonosParaAsignar.remove(telefono);
        sedeParaActualizar.setTelefonos(telefonosParaAsignar);

        return this.actualizar(sedeParaActualizar);
    }

    @Override
    public SedeDto actualizarObraSocial(Long id, Long obraSocialId) {
        Sede sedeParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sede no encontrada"));
        ObraSocial obraSocialParaAsignar = obraSocialRepository.findById(obraSocialId).orElseThrow(()-> new EntidadNoEncontradaException("Obra social no encontrada"));

        sedeParaActualizar.setObraSocial(obraSocialParaAsignar);

        return this.actualizar(sedeParaActualizar);
    }


}

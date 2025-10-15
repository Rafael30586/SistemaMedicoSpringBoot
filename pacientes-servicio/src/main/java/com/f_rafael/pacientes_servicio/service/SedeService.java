package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.SedeDto;
import com.f_rafael.pacientes_servicio.dto.SubSedeDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.ObraSocial;
import com.f_rafael.pacientes_servicio.model.Sede;
import com.f_rafael.pacientes_servicio.repository.IDireccionClient;
import com.f_rafael.pacientes_servicio.repository.INumeroTelefonicoClient;
import com.f_rafael.pacientes_servicio.repository.IObraSocialRepository;
import com.f_rafael.pacientes_servicio.repository.ISedeRepository;
import com.f_rafael.pacientes_servicio.mapper.SedeMapper;
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
    private IDireccionClient direccionClient;
    private INumeroTelefonicoClient numeroTelefonicoClient;
    private IObraSocialRepository obraSocialRepository;

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

        if(sede.getDireccionId() == null){ // ¿Cómo podría hacer para confirmar que la direccion existe si está en otro microservicio?
            throw new CampoNuloException("La direccion no puede ser nula");
        }

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
            if(direccionClient.obtenerInformacionDireccion(s.getDireccionId()).getCalle().equals(calle)){
                listaARetornar.add(mapper.obtenerDto(s));
            }
        }

        return listaARetornar;
    }

    @Override
    public SedeDto buscarPortelefono(String telefono) {
        SedeDto dtoARetornar;
        List<Sede> informacionSedes = repository.findAll();
        Set<Long> telefonosId;

        for(Sede s : informacionSedes){
            telefonosId = s.getTelefonosId();

            for(Long id : telefonosId){
                if(telefono.equals(numeroTelefonicoClient.buscarPorId(id).getNumero())){
                    dtoARetornar = mapper.obtenerDto(s);
                    return dtoARetornar;
                }
            }
        }
        throw new EntidadNoEncontradaException("Entidad no encontrada");
    }

    @Override
    public SedeDto actualizarDireccion(Long id, Long direccionId) {
        Sede sedeParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sede no encontrada"));
        sedeParaActualizar.setDireccionId(direccionId);

        return mapper.obtenerDto(repository.save(sedeParaActualizar));
    }

    @Override
    public SedeDto agregarTelefono(Long id, Long telefonoId) {
        Sede sedeParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sede no encontrada"));
        Set<Long> telefonosIds = sedeParaActualizar.getTelefonosId();

        telefonosIds.add(telefonoId); // Agregar validación para confirmar si el teléfono existe en el optro microservicio
        sedeParaActualizar.setTelefonosId(telefonosIds);

        return mapper.obtenerDto(repository.save(sedeParaActualizar));
    }

    @Override
    public SedeDto quitarTelefono(Long id, Long telefonoId) {
        Sede sedeParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sede no encontrada"));
        Set<Long> telefonosIds = sedeParaActualizar.getTelefonosId();

        telefonosIds.remove(telefonoId);
        sedeParaActualizar.setTelefonosId(telefonosIds);

        return mapper.obtenerDto(repository.save(sedeParaActualizar));
    }

    @Override
    public SedeDto actualizarObraSocial(Long id, Long obraSocialId) {
        Sede sedeParaActualizar = repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sede no encontrada"));
        ObraSocial obraSocialParaAsignar = obraSocialRepository.findById(obraSocialId).orElseThrow(()-> new EntidadNoEncontradaException("Obra social no encontrada"));

        sedeParaActualizar.setObraSocial(obraSocialParaAsignar);

        return mapper.obtenerDto(repository.save(sedeParaActualizar));
    }


}

package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.SedeDto;
import com.f_rafael.pacientes_servicio.dto.SubSedeDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.Sede;
import com.f_rafael.pacientes_servicio.repository.IDireccionClient;
import com.f_rafael.pacientes_servicio.repository.INumeroTelefonicoClient;
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


}

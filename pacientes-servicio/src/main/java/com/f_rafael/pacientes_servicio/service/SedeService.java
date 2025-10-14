package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.SubSedeDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.Sede;
import com.f_rafael.pacientes_servicio.repository.IDireccionClient;
import com.f_rafael.pacientes_servicio.repository.INumeroTelefonicoClient;
import com.f_rafael.pacientes_servicio.repository.ISedeRepository;
import com.f_rafael.pacientes_servicio.utils.SedeMapper;
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
    public SubSedeDto buscarPorId(Long id) {
        SubSedeDto dtoARetornar;

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        dtoARetornar = mapper.obtenerDto(repository.findById(id).get());
        return dtoARetornar;
    }

    @Override
    public List<SubSedeDto> buscarTodas() {
        List<SubSedeDto> listaARetornar = mapper.obtenerListaDtos(repository.findAll());
        return listaARetornar;
    }

    @Override
    public SubSedeDto guardar(Sede sede) {
        SubSedeDto dtoARetornar;

        if(sede.getDireccionId() == null){ // ¿Cómo podría hacer para confirmar que la direccion existe si está en otro microservicio?
            throw new CampoNuloException("La direccion no puede ser nula");
        }

        dtoARetornar = mapper.obtenerDto(repository.save(sede));
        return dtoARetornar;
    }

    @Override
    public SubSedeDto actualizar(Sede sede) {

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
    public List<SubSedeDto> buscarPorDireccion(String calle) {
        List<SubSedeDto> listaARetornar = new LinkedList<>();
        List<Sede> informacionSedes = repository.findAll();

        for(Sede s : informacionSedes){
            if(direccionClient.obtenerInformacionDireccion(s.getDireccionId()).getCalle().equals(calle)){
                listaARetornar.add(mapper.obtenerDto(s));
            }
        }

        return listaARetornar;
    }

    @Override
    public SubSedeDto buscarPortelefono(String telefono) {
        SubSedeDto dtoARetornar;
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

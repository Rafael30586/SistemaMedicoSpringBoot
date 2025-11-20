package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.AdministracionFarmacoMapper;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.repository.IAdministracionFarmacoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class AdministarcionFarmacoService implements IAdministracionFarmacoService{

    private IAdministracionFarmacoRepository repository;
    private AdministracionFarmacoMapper mapper;

    @Override
    public AdministracionFarmacoDto buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<AdministracionFarmacoDto> buscarTodas() {
        return mapper.obtenerListaDtos(repository.findAll());
    }

    @Override
    public AdministracionFarmacoDto guardar(AdministracionFarmaco administracion) {
        if(administracion.getVia() == null){
            throw new CampoNuloException("La via no puede swer nula");
        }

        return mapper.obtenerDto(repository.save(administracion));
    }


    @Override
    public AdministracionFarmacoDto actualizar(AdministracionFarmaco administracion) {
        Long id = administracion.getId();

        if(id == null || administracion.getVia() == null){
            throw new CampoNuloException("Ni el id ni la via pueden ser nulos");
        }

        return this.guardar(administracion);
    }

    @Override
    public void borrarPorId(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public AdministracionFarmacoDto buscarPorVia(String via) {

        if(repository.findByVia(via).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findByVia(via).get());
    }


}

package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import com.f_rafael.farmacia_servicio.repository.IAdministarcionFarmacoRepository;
import com.f_rafael.farmacia_servicio.utils.TransformacionAdministracionFarmaco;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdministarcionFarmacoService implements IAdministracionFarmacoService{

    private IAdministarcionFarmacoRepository repository;

    @Override
    public Optional<AdministracionFarmaco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public AdministracionFarmacoDto buscarPorId2(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionAdministracionFarmaco.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<AdministracionFarmaco> buscarTodas() {

        return repository.findAll();
    }

    @Override
    public List<AdministracionFarmacoDto> buscarTodas2() {
        return TransformacionAdministracionFarmaco.obtenerListaDtos(repository.findAll());
    }

    @Override
    public AdministracionFarmaco guardar(AdministracionFarmaco administracion) {
        return repository.save(administracion);
    }

    @Override
    public AdministracionFarmacoDto guardar2(AdministracionFarmaco administracion) {
        if(administracion.getVia() == null){
            throw new CampoNuloException("La via no puede swer nula");
        }

        return TransformacionAdministracionFarmaco.obtenerDto(repository.save(administracion));
    }

    @Override
    public AdministracionFarmaco actualizar(AdministracionFarmaco administracion) {
        return this.guardar(administracion);
    }

    @Override
    public AdministracionFarmacoDto actualizar2(AdministracionFarmaco administracion) {
        Long id = administracion.getId();

        if(id == null || administracion.getVia() == null){
            throw new CampoNuloException("Ni el id ni la via pueden ser nulos");
        }

        return this.guardar2(administracion);
    }

    @Override
    public void borrarPorId(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public Optional<AdministracionFarmaco> buscarPorVia(String via) {
        return repository.findByVia(via);
    }

    @Override
    public AdministracionFarmacoDto buscarPorVia2(String via) {

        if(repository.findByVia(via).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionAdministracionFarmaco.obtenerDto(repository.findByVia(via).get());
    }
}

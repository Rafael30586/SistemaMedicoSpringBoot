package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
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

    @Override
    public AdministracionFarmacoDto buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<AdministracionFarmacoDto> buscarTodas() {
        return obtenerListaDtos(repository.findAll());
    }

    @Override
    public AdministracionFarmacoDto guardar(AdministracionFarmaco administracion) {
        if(administracion.getVia() == null){
            throw new CampoNuloException("La via no puede swer nula");
        }

        return obtenerDto(repository.save(administracion));
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

        return obtenerDto(repository.findByVia(via).get());
    }

    private AdministracionFarmacoDto obtenerDto(AdministracionFarmaco administracion){

        AdministracionFarmacoDto dtoARetornar = new AdministracionFarmacoDto();
        SubMedicamentoDto medicamentoAAsignar;
        Set<SubMedicamentoDto> medicamentosAAsignar;
        Optional<Set<Medicamento>> medicamentosOptional = Optional.of(administracion.getMedicamentos());
        Set<Medicamento> informacionMedicamentos;

        if(medicamentosOptional.isPresent()){

            informacionMedicamentos = administracion.getMedicamentos();
            medicamentosAAsignar = new HashSet<>();

            for(Medicamento m : informacionMedicamentos){
                medicamentoAAsignar = new SubMedicamentoDto(m.getId(),
                        m.getPrincipioActivo().getNombre(),
                        m.getFormaFarmaceutica().getNombre(),
                        m.getAdministracion().getVia(),
                        m.getMarca().getNombre());

                medicamentosAAsignar.add(medicamentoAAsignar);
            }

            dtoARetornar.setMedicamentos(medicamentosAAsignar);
        }

        dtoARetornar.setId(administracion.getId());
        dtoARetornar.setVia(administracion.getVia());

        return dtoARetornar;
    }


    private List<AdministracionFarmacoDto> obtenerListaDtos(Collection<AdministracionFarmaco> coleccionAdministracionFarmaco){
        List<AdministracionFarmacoDto> listaARetornar = new LinkedList<>();

        for(AdministracionFarmaco af : coleccionAdministracionFarmaco){
            listaARetornar.add(obtenerDto(af));
        }

        return listaARetornar;
    }
}

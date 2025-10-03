package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.FormaFarmaceuticaDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.repository.IFormaFarmaceuticaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class FormaFarmaceuticaService implements IFormaFarmaceuticaService{

    private IFormaFarmaceuticaRepository repository;

    @Override
    public FormaFarmaceuticaDto buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<FormaFarmaceuticaDto> buscarTodas() {
        return obtenerListaDtos(repository.findAll());
    }

    @Override
    public FormaFarmaceuticaDto guardar(FormaFarmaceutica formaFarmaceutica) {

        if(formaFarmaceutica.getNombre() == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        return obtenerDto(repository.save(formaFarmaceutica));
    }

    @Override
    public FormaFarmaceuticaDto actualizar(FormaFarmaceutica formaFarmaceutica) {
        Long id = formaFarmaceutica.getId();

        if(id == null || formaFarmaceutica.getNombre() == null){
            throw new CampoNuloException("El id y el nombre no pueden ser nulos");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar(formaFarmaceutica);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public FormaFarmaceuticaDto buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return obtenerDto(repository.findByNombre(nombre).get());
    }

    private FormaFarmaceuticaDto obtenerDto(FormaFarmaceutica formaFarmaceutica){
        FormaFarmaceuticaDto dtoARetornar = new FormaFarmaceuticaDto();
        Set<Medicamento> informacionMedicamentos;
        Optional<Set<Medicamento>> medicamentosOptional = Optional.of(formaFarmaceutica.getMedicamentos());
        SubMedicamentoDto medicamentoParaAgregar;
        Set<SubMedicamentoDto> medicamentosParaAsignar;

        if(medicamentosOptional.isPresent()){
            informacionMedicamentos = formaFarmaceutica.getMedicamentos();
            medicamentosParaAsignar = new HashSet<>();

            for(Medicamento m : informacionMedicamentos){
                medicamentoParaAgregar = new SubMedicamentoDto(m.getId(),
                        m.getPrincipioActivo().getNombre(),
                        m.getFormaFarmaceutica().getNombre(),
                        m.getAdministracion().getVia(),
                        m.getMarca().getNombre());

                medicamentosParaAsignar.add(medicamentoParaAgregar);
            }

            dtoARetornar.setMedicamento(medicamentosParaAsignar);
        }

        dtoARetornar.setId(formaFarmaceutica.getId());
        dtoARetornar.setNombre(formaFarmaceutica.getNombre());

        return dtoARetornar;
    }

    private List<FormaFarmaceuticaDto> obtenerListaDtos(Collection<FormaFarmaceutica> coleccionFormasFarmaceuticas){
        List<FormaFarmaceuticaDto> listaARetornar = new LinkedList<>();

        for(FormaFarmaceutica ff : coleccionFormasFarmaceuticas){
            listaARetornar.add(obtenerDto(ff));
        }

        return listaARetornar;
    }
}

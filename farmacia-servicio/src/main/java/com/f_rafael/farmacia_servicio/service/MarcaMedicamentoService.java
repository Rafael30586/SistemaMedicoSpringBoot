package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.repository.IMarcaMedicamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class MarcaMedicamentoService implements IMarcaMedicamentoService{

    private IMarcaMedicamentoRepository repository;

    @Override
    public MarcaMedicamentoDto buscarPorId(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<MarcaMedicamentoDto> buscarTodas() {
        return obtenerListaDtos(repository.findAll());
    }


    @Override
    public MarcaMedicamentoDto guardar(MarcaMedicamento marca) {
        return obtenerDto(repository.save(marca));
    }

    @Override
    public MarcaMedicamentoDto actualizar(MarcaMedicamento marca) {
        Long id = marca.getId();

        if(id == null || marca.getNombre() == null){
            throw new CampoNuloException("El id y el nombre no pueden ser nulos");
        }

        return this.guardar(marca);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public MarcaMedicamentoDto buscarPorNombre(String nombre) {

        if(repository.findByNombre(nombre).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return obtenerDto(repository.findByNombre(nombre).get());
    }

    private MarcaMedicamentoDto obtenerDto(MarcaMedicamento marca){
        MarcaMedicamentoDto dtoARetornar = new MarcaMedicamentoDto();
        Set<Medicamento> informacionMedicamentos;
        Optional<Set<Medicamento>> medicamentosOptional = Optional.of(marca.getMedicamentos());
        Set<SubMedicamentoDto> medicamentosParaAsignar;
        SubMedicamentoDto medicamentoParaAgregar;

        if(medicamentosOptional.isPresent()){
            informacionMedicamentos = marca.getMedicamentos();
            medicamentosParaAsignar = new HashSet<>();

            for(Medicamento m : informacionMedicamentos){
                medicamentoParaAgregar = new SubMedicamentoDto(m.getId(),
                        m.getPrincipioActivo().getNombre(),
                        m.getFormaFarmaceutica().getNombre(),
                        m.getAdministracion().getVia(),
                        m.getMarca().getNombre());

                medicamentosParaAsignar.add(medicamentoParaAgregar);
            }
            dtoARetornar.setMedicamentos(medicamentosParaAsignar);
        }
        dtoARetornar.setId(marca.getId());
        dtoARetornar.setNombre(marca.getNombre());

        return dtoARetornar;
    }

    private List<MarcaMedicamentoDto> obtenerListaDtos(Collection<MarcaMedicamento> coleccionMarcaMedicamento){
        List<MarcaMedicamentoDto> listaARetornar = new LinkedList<>();
        for(MarcaMedicamento mm : coleccionMarcaMedicamento){
            listaARetornar.add(obtenerDto(mm));
        }
        return listaARetornar;
    }
}

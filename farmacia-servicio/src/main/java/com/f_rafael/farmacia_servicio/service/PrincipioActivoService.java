package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.PrincipioActivoDto;
import com.f_rafael.farmacia_servicio.dto.SubAccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.repository.IPrincipioActivoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PrincipioActivoService implements IPrincipioActivoService{

    private IPrincipioActivoRepository repository;

    @Override
    public PrincipioActivoDto buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<PrincipioActivoDto> buscarTodos() {
        return obtenerListaDto(repository.findAll());
    }

    @Override
    public PrincipioActivoDto guardar(PrincipioActivo principioActivo) {
        if(principioActivo.getNombre() == null){
            throw new CampoNuloException("El nombre no puede ser nulo");
        }

        return obtenerDto(repository.save(principioActivo));
    }


    @Override
    public PrincipioActivoDto actualizar(PrincipioActivo principioActivo) {
        Long id = principioActivo.getId();

        if(id == null){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar(principioActivo);
    }

    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<PrincipioActivoDto> buscarPorAccionTerapeutica(String nombreAccionTerapeutica) {
        List<PrincipioActivo> principiosActivosARetornar = new LinkedList<>();
        List<PrincipioActivo> todosLosPrincipiosActivos = repository.findAll();
        Set<AccionTerapeutica> accionesTerapeuticas;
        boolean tieneLaAccionTerapeutica;

        for(PrincipioActivo pa : todosLosPrincipiosActivos){
            tieneLaAccionTerapeutica = false;

            accionesTerapeuticas = pa.getAccionesTerapeuticas();

            for(AccionTerapeutica at : accionesTerapeuticas){
                if(at.getNombre().equals(nombreAccionTerapeutica)) tieneLaAccionTerapeutica = true;
            }

            if(tieneLaAccionTerapeutica) principiosActivosARetornar.add(pa);
        }

        return obtenerListaDto(principiosActivosARetornar);
    }

    private PrincipioActivoDto obtenerDto(PrincipioActivo principioActivo){
        PrincipioActivoDto dtoARetornar = new PrincipioActivoDto();

        Set<SubAccionTerapeuticaDto> accionesTerapeuticasParaAsignar;
        SubAccionTerapeuticaDto accionTerapeuticaParaAsignar;
        Set<AccionTerapeutica> informacionAccionesTerapeuticas;
        Optional<Set<AccionTerapeutica>> accionesTerapeutciasOptional = Optional.of(principioActivo.getAccionesTerapeuticas());

        SubMedicamentoDto medicamentoParaAsignar;
        Set<SubMedicamentoDto> medicamentosParaAsignar;
        Optional<Set<Medicamento>> optionalMedicamentos = Optional.of(principioActivo.getMedicamentos());
        Set<Medicamento> informacionMedicamentos;

        dtoARetornar.setId(principioActivo.getId());
        dtoARetornar.setNombre(principioActivo.getNombre());

        if(accionesTerapeutciasOptional.isPresent()){
            informacionAccionesTerapeuticas = principioActivo.getAccionesTerapeuticas();
            accionesTerapeuticasParaAsignar = new HashSet<>();

            for(AccionTerapeutica at : informacionAccionesTerapeuticas){
                accionTerapeuticaParaAsignar = new SubAccionTerapeuticaDto(at.getId(),at.getNombre());
                accionesTerapeuticasParaAsignar.add(accionTerapeuticaParaAsignar);
            }

            dtoARetornar.setAccionesTerapeuticas(accionesTerapeuticasParaAsignar);
        }

        if(optionalMedicamentos.isPresent()){
            informacionMedicamentos = principioActivo.getMedicamentos();
            medicamentosParaAsignar = new HashSet<>();

            for(Medicamento m : informacionMedicamentos){
                medicamentoParaAsignar = new SubMedicamentoDto(m.getId(),
                        m.getPrincipioActivo().getNombre(),
                        m.getFormaFarmaceutica().getNombre(),
                        m.getAdministracion().getVia(),
                        m.getMarca().getNombre());

                medicamentosParaAsignar.add(medicamentoParaAsignar);
            }

            dtoARetornar.setMedicamentos(medicamentosParaAsignar);
        }

        return dtoARetornar;
    }

    private List<PrincipioActivoDto> obtenerListaDto(Collection<PrincipioActivo> principiosActivos){
        List<PrincipioActivoDto> listaARetornar = new LinkedList<>();
        PrincipioActivoDto dtoParaAgregar;

        for(PrincipioActivo pa : principiosActivos){
            dtoParaAgregar = obtenerDto(pa);
            listaARetornar.add(dtoParaAgregar);
        }

        return listaARetornar;
    }
}

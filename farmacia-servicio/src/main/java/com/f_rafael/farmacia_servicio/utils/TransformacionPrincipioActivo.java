package com.f_rafael.farmacia_servicio.utils;

import com.f_rafael.farmacia_servicio.dto.PrincipioActivoDto;
import com.f_rafael.farmacia_servicio.dto.SubAccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;

import java.util.*;

public class TransformacionPrincipioActivo {

    public static PrincipioActivoDto obtenerDto(PrincipioActivo principioActivo){
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

    public static List<PrincipioActivoDto> obtenerListaDto(Collection<PrincipioActivo> principiosActivos){
        List<PrincipioActivoDto> listaARetornar = new LinkedList<>();
        PrincipioActivoDto dtoParaAgregar;

        for(PrincipioActivo pa : principiosActivos){
            dtoParaAgregar = obtenerDto(pa);
            listaARetornar.add(dtoParaAgregar);
        }

        return listaARetornar;
    }


}

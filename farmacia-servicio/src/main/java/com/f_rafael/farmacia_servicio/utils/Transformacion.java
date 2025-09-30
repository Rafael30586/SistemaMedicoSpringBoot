package com.f_rafael.farmacia_servicio.utils;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.PrincipioActivoDto;
import com.f_rafael.farmacia_servicio.dto.SubAccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.SubPrincipioActivoDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;

import java.util.*;

public class Transformacion {

    public static String removerGuionesBajos(String texto){
        return texto.replace('_',' ');
    }

    public static PrincipioActivoDto dePrincipioActivoADto(PrincipioActivo principioActivo){
        PrincipioActivoDto dtoARetornar = new PrincipioActivoDto();
        Set<SubAccionTerapeuticaDto> accionesTerapeuticasParaAsignar;
        SubAccionTerapeuticaDto accionTerapeuticaParaAsignar;
        Set<AccionTerapeutica> informacionAccionesTerapeuticas;
        Optional<Set<AccionTerapeutica>> accionesTerapeutciasOptional = Optional.of(principioActivo.getAccionesTerapeuticas());

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

        return dtoARetornar;
    }

    public static List<PrincipioActivoDto> obtenerListaDePrincipioActivoDto(Collection<PrincipioActivo> principiosActivos){
        List<PrincipioActivoDto> listaARetornar = new LinkedList<>();
        PrincipioActivoDto dtoParaAgregar;

        for(PrincipioActivo pa : principiosActivos){
            dtoParaAgregar = dePrincipioActivoADto(pa);
            listaARetornar.add(dtoParaAgregar);
        }

        return listaARetornar;
    }

    public static AccionTerapeuticaDto deAccionTerapeuticaADto(AccionTerapeutica informacionAccionTerapeutica){
        Optional<Set<PrincipioActivo>> principiosActivosOpcional = Optional.of(informacionAccionTerapeutica.getPrincipiosActivos());
        Set<PrincipioActivo> informacionPrincipiosActivos;
        AccionTerapeuticaDto dtoARetornar = new AccionTerapeuticaDto();
        Set<SubPrincipioActivoDto> principiosActivosParaAsignar;
        SubPrincipioActivoDto principioActivoParaAsignar;

        dtoARetornar.setId(informacionAccionTerapeutica.getId());
        dtoARetornar.setNombre(informacionAccionTerapeutica.getNombre());

        if(principiosActivosOpcional.isPresent()){
            informacionPrincipiosActivos = principiosActivosOpcional.get();
            principiosActivosParaAsignar = new HashSet<>();

            for(PrincipioActivo pa : informacionPrincipiosActivos){
                principioActivoParaAsignar = new SubPrincipioActivoDto(pa.getId(), pa.getNombre());
                principiosActivosParaAsignar.add(principioActivoParaAsignar);
            }

            dtoARetornar.setPrincipiosActivos(principiosActivosParaAsignar);
        }
        return dtoARetornar;
    }

    public static List<AccionTerapeuticaDto> obtenerListaDeAccionesTerapeuticasDto(Collection<AccionTerapeutica> accionesTerapeuticas){
        List<AccionTerapeuticaDto> listaARetornar = new LinkedList<>();
        AccionTerapeuticaDto dtoParaAgregar;

        for(AccionTerapeutica at : accionesTerapeuticas){
            dtoParaAgregar = deAccionTerapeuticaADto(at);
            listaARetornar.add(dtoParaAgregar);
        }

        return listaARetornar;
    }
}

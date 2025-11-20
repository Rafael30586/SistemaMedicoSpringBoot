package com.f_rafael.farmacia_servicio.mapper;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.SubPrincipioActivoDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AccionTerapeuticaMapper {

    private AccionTerapeuticaDto obtenerDto(AccionTerapeutica informacionAccionTerapeutica){
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

    private List<AccionTerapeuticaDto> obtenerListaDto(Collection<AccionTerapeutica> accionesTerapeuticas){

        List<AccionTerapeuticaDto> listaARetornar = new LinkedList<>();
        AccionTerapeuticaDto dtoParaAgregar;

        for(AccionTerapeutica at : accionesTerapeuticas){
            dtoParaAgregar = obtenerDto(at);
            listaARetornar.add(dtoParaAgregar);
        }

        return listaARetornar;
    }
}

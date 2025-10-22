package com.f_rafael.hospital_servicio.mapper;

import com.f_rafael.hospital_servicio.dto.DiagnosticoDto;
import com.f_rafael.hospital_servicio.model.Diagnostico;
import com.f_rafael.hospital_servicio.model.Signo;
import com.f_rafael.hospital_servicio.model.Sintoma;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DiagnosticoMapper {

    public DiagnosticoDto obtenerDto(Diagnostico informacionDiagnostico){
        DiagnosticoDto dtoARetornar = new DiagnosticoDto();
        Set<String> sintomasParaAsignar;
        Set<String> signosParaAsignar;
        Set<Sintoma> informacionSintomas;
        Set<Signo> informacionSignos;

        dtoARetornar.setId(informacionDiagnostico.getId());
        dtoARetornar.setNombre(informacionDiagnostico.getNombre());

        if(informacionDiagnostico.getSignos() != null){
            informacionSignos = informacionDiagnostico.getSignos();
            signosParaAsignar = informacionSignos.stream().parallel().map( is -> is.getNombre()).collect(Collectors.toSet());
            dtoARetornar.setSignos(signosParaAsignar);
        }

        if(informacionDiagnostico.getSintomas() != null){
            informacionSintomas = informacionDiagnostico.getSintomas();
            sintomasParaAsignar = informacionSintomas.stream().parallel().map(is -> is.getNombre()).collect(Collectors.toSet());
            dtoARetornar.setSintomas(sintomasParaAsignar);
        }

        return dtoARetornar;
    }

    public List<DiagnosticoDto> obtenerListaDto(Collection<Diagnostico> informacionDiagnosticos){
        List<DiagnosticoDto> listaParaRetornar = new LinkedList<>();

        for(Diagnostico d : informacionDiagnosticos){
            listaParaRetornar.add(obtenerDto(d));
        }

        return listaParaRetornar;
    }
}

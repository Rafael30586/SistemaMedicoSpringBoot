package com.f_rafael.hospital_servicio.mapper;

import com.f_rafael.hospital_servicio.dto.SintomaDto;
import com.f_rafael.hospital_servicio.model.Diagnostico;
import com.f_rafael.hospital_servicio.model.Sintoma;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class SintomaMapper {

    public SintomaDto obtenerDto(Sintoma informacionSintoma){
        SintomaDto dtoAretornar = new SintomaDto();
        Set<Diagnostico> informacionDiagnosticos;
        Set<String> diagnosticosParaAsignar;

        dtoAretornar.setId(informacionSintoma.getId());
        dtoAretornar.setNombre(informacionSintoma.getNombre());

        if(informacionSintoma.getDiagnosticos() != null){
            informacionDiagnosticos = informacionSintoma.getDiagnosticos();

            diagnosticosParaAsignar = informacionDiagnosticos.stream().map(id -> id.getNombre()).collect(Collectors.toSet());

            dtoAretornar.setDiagnosticos(diagnosticosParaAsignar);
        }

        return dtoAretornar;
    }

    public List<SintomaDto> obtenerListaDto(Collection<Sintoma> informacionSintomas){
        List<SintomaDto> listaParaRetornar = new LinkedList<>();

        for(Sintoma s : informacionSintomas){
            listaParaRetornar.add(obtenerDto(s));
        }

        return  listaParaRetornar;
    }
}

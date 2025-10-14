package com.f_rafael.pacientes_servicio.mapper;

import com.f_rafael.pacientes_servicio.dto.SubObraSocialDto;
import com.f_rafael.pacientes_servicio.model.ObraSocial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class SubObraSocialMapper {

    public SubObraSocialDto obtenerDto(ObraSocial informacionObraSocail){
        SubObraSocialDto dtoARetornar = new SubObraSocialDto();

        dtoARetornar.setId(informacionObraSocail.getId());
        dtoARetornar.setNombre(informacionObraSocail.getNombre());

        return dtoARetornar;
    }

    public List<SubObraSocialDto> obtenerListaDto(Collection<ObraSocial> informacionObrasSociales){
        List<SubObraSocialDto> listaaRetornar = new LinkedList<>();

        for(ObraSocial os : informacionObrasSociales){
            listaaRetornar.add(obtenerDto(os));
        }

        return listaaRetornar;
    }
}

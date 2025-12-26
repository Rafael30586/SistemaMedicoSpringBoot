package com.f_rafael.pacientes_servicio.mapper;

import com.f_rafael.pacientes_servicio.dto.SedeDto;
import com.f_rafael.pacientes_servicio.dto.SubObraSocialDto;
import com.f_rafael.pacientes_servicio.model.Sede;
import com.f_rafael.pacientes_servicio.repository.IContactoClient;
import com.f_rafael.pacientes_servicio.repository.IDireccionClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@AllArgsConstructor
@Component
public class SedeMapper {


    // private IDireccionClient direccionClient;
    private SubObraSocialMapper subObraSocialMapper;
    private IContactoClient contactoClient;


    public SedeDto obtenerDto(Sede informacionSede){
        SedeDto dtoaRetornar = new SedeDto();
        SubObraSocialDto obraSocialParaAsignar;

        dtoaRetornar.setId(informacionSede.getId());
        dtoaRetornar.setDireccion(contactoClient.obtenerDireccionPorId(informacionSede.getDireccionId()));
        dtoaRetornar.setTelefonos(informacionSede.getTelefonos());


        if(informacionSede.getObraSocial() != null){
            obraSocialParaAsignar = subObraSocialMapper.obtenerDto(informacionSede.getObraSocial());
            dtoaRetornar.setObraSocial(obraSocialParaAsignar);
        }

        return dtoaRetornar;
    }

    public List<SedeDto> obtenerListaDto(Collection<Sede> informacionSedes){
        List<SedeDto> listaARetornar = new LinkedList<>();

        for(Sede s : informacionSedes){
            listaARetornar.add(obtenerDto(s));
        }

        return listaARetornar;
    }
}

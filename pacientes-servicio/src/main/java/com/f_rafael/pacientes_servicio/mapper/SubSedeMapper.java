package com.f_rafael.pacientes_servicio.mapper;

import com.f_rafael.pacientes_servicio.dto.SubSedeDto;
import com.f_rafael.pacientes_servicio.model.Sede;
import com.f_rafael.pacientes_servicio.repository.IDireccionClient;
import com.f_rafael.pacientes_servicio.repository.INumeroTelefonicoClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@AllArgsConstructor
@Component
public class SubSedeMapper {

    private INumeroTelefonicoClient numeroTelefonicoClient;
    private IDireccionClient direccionClient;

    public SubSedeDto obtenerDto(Sede informacionSede){
        SubSedeDto dtoARetornar = new SubSedeDto();

        dtoARetornar.setId(informacionSede.getId());
/*
        if(sede.getTelefonos() != null){
            telefonos = sede.getTelefonos();

            for(String telefono : telefonos){
                telefonosParaAsignar.add(numeroTelefonicoClient.buscarPorId(telefono));
            }

            dtoARetornar.setTelefonos(telefonosParaAsignar);
        }*/
        dtoARetornar.setTelefonos(informacionSede.getTelefonos());

        if(informacionSede.getDireccionId() != null){
            dtoARetornar.setDireccion(direccionClient.obtenerInformacionDireccion(informacionSede.getDireccionId()));
        }

        return dtoARetornar;
    }

    public List<SubSedeDto> obtenerListaDto(Collection<Sede> informacionSedes){
        List<SubSedeDto> listaARetornar = new LinkedList<>();

        for(Sede s : informacionSedes){
            listaARetornar.add(obtenerDto(s));
        }

        return listaARetornar;
    }
}

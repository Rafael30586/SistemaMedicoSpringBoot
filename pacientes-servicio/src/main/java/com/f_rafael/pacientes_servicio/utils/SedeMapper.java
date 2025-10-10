package com.f_rafael.pacientes_servicio.utils;

import com.f_rafael.pacientes_servicio.dto.NumeroTelefonicoDto;
import com.f_rafael.pacientes_servicio.dto.SedeDto;
import com.f_rafael.pacientes_servicio.model.Sede;
import com.f_rafael.pacientes_servicio.repository.IDireccionClient;
import com.f_rafael.pacientes_servicio.repository.INumeroTelefonicoClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@AllArgsConstructor
@Component
public class SedeMapper {


    private IDireccionClient direccionClient;
    private INumeroTelefonicoClient numeroTelefonicoClient;


    public SedeDto obtenerDto(Sede informacionSede){
        SedeDto dtoaRetornar = new SedeDto();
        Set<Long> telefonosId;
        Set<NumeroTelefonicoDto> telefonosParaAsignar;

        dtoaRetornar.setId(informacionSede.getId());
        dtoaRetornar.setDireccion(direccionClient.obtenerInformacionDireccion(informacionSede.getDireccionId()));

        if(informacionSede.getTelefonosId()!=null){
            telefonosParaAsignar = new HashSet<>();
            telefonosId = informacionSede.getTelefonosId();

            for(Long id : telefonosId){
                telefonosParaAsignar.add(numeroTelefonicoClient.buscarPorId(id));
            }

            dtoaRetornar.setTelefonos(telefonosParaAsignar);
        }

        return dtoaRetornar;
    }

    public List<SedeDto> obtenerListaDtos(Collection<Sede> informacionSedes){
        List<SedeDto> listaARetornar = new LinkedList<>();

        for(Sede s : informacionSedes){
            listaARetornar.add(obtenerDto(s));
        }

        return listaARetornar;
    }
}

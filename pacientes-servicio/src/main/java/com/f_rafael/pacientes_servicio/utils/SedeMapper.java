package com.f_rafael.pacientes_servicio.utils;

import com.f_rafael.pacientes_servicio.dto.NumeroTelefonicoDto;
import com.f_rafael.pacientes_servicio.dto.SubSedeDto;
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


    public SubSedeDto obtenerDto(Sede informacionSede){
        SubSedeDto dtoaRetornar = new SubSedeDto();
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

    public List<SubSedeDto> obtenerListaDtos(Collection<Sede> informacionSedes){
        List<SubSedeDto> listaARetornar = new LinkedList<>();

        for(Sede s : informacionSedes){
            listaARetornar.add(obtenerDto(s));
        }

        return listaARetornar;
    }
}

package com.f_rafael.pacientes_servicio.mapper;

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
public class SubSedeMapper {

    private INumeroTelefonicoClient numeroTelefonicoClient;
    private IDireccionClient direccionClient;

    public SubSedeDto obtenerDto(Sede sede){
        SubSedeDto dtoARetornar = new SubSedeDto();
        Set<NumeroTelefonicoDto> telefonosParaAsignar = new HashSet<>();
        Set<Long> telefonosId;

        dtoARetornar.setId(sede.getId());

        if(sede.getTelefonosId() != null){
            telefonosId = sede.getTelefonosId();

            for(Long telefonoId : telefonosId){
                telefonosParaAsignar.add(numeroTelefonicoClient.buscarPorId(telefonoId));
            }

            dtoARetornar.setTelefonos(telefonosParaAsignar);
        }

        if(sede.getDireccionId() != null){
            dtoARetornar.setDireccion(direccionClient.obtenerInformacionDireccion(sede.getDireccionId()));
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

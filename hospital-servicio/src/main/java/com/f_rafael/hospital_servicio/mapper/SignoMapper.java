package com.f_rafael.hospital_servicio.mapper;

import com.f_rafael.hospital_servicio.dto.SignoDto;
import com.f_rafael.hospital_servicio.model.Diagnostico;
import com.f_rafael.hospital_servicio.model.Signo;
import com.f_rafael.hospital_servicio.repository.IFarmaciaClient;
import com.f_rafael.hospital_servicio.repository.IUnidadDeMedidaClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SignoMapper {

    // private IUnidadDeMedidaClient unidadDeMedidaClient;
    private IFarmaciaClient farmaciaClient;

    public SignoDto obtenerDto(Signo signo){
        SignoDto dtoARetornar = new SignoDto();
        Set<Diagnostico> informacionDiagnosticos;
        Set<String> diagnosticosParaAsignar;

        dtoARetornar.setId(signo.getId());
        dtoARetornar.setNombre(signo.getNombre());
        dtoARetornar.setValorMinimo(signo.getValorMinimo());
        dtoARetornar.setValorMaximo(signo.getValorMaximo());
        dtoARetornar.setDescripcion(signo.getDescripcion());
        dtoARetornar.setUnidad(farmaciaClient.buscarUnidadPorId(signo.getUnidadId()));

        if(signo.getDiagnosticos() != null){
            informacionDiagnosticos = signo.getDiagnosticos();

            diagnosticosParaAsignar = informacionDiagnosticos.stream().map(id -> id.getNombre()).collect(Collectors.toSet());

            dtoARetornar.setDiagnosticos(diagnosticosParaAsignar);
        }

        return dtoARetornar;
    }

    public List<SignoDto> obtenerListaDto(Collection<Signo> informacionSignos){
        List<SignoDto> listaParaRetornar = new LinkedList<>();

        for(Signo s : informacionSignos){
            listaParaRetornar.add(obtenerDto(s));
        }

        return listaParaRetornar;
    }
}

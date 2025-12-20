package com.f_rafael.hospital_servicio.mapper;

import com.f_rafael.hospital_servicio.dto.FisioterapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.FisioterapiaPaciente;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class FisioterapiaPacienteMapper {

    private IPacienteClient pacienteClient;


    public FisioterapiaPacienteDto obtenerDto(FisioterapiaPaciente informacionFisioterapia){
        FisioterapiaPacienteDto dtoARetornar = new FisioterapiaPacienteDto();

        dtoARetornar.setId(informacionFisioterapia.getId());
        dtoARetornar.setPaciente(pacienteClient.buscarPacientePorId(informacionFisioterapia.getPacienteId()));
        dtoARetornar.setInicio(informacionFisioterapia.getInicio());
        dtoARetornar.setFin(informacionFisioterapia.getFin());

        return dtoARetornar;
    }

    public List<FisioterapiaPacienteDto> obtenerListaDto(Collection<FisioterapiaPaciente> informacionFisioterapias){
        List<FisioterapiaPacienteDto> listaParaRetornar = new LinkedList<>();

        for(FisioterapiaPaciente fp : informacionFisioterapias){
            listaParaRetornar.add(obtenerDto(fp));
        }

        return listaParaRetornar;
    }
}

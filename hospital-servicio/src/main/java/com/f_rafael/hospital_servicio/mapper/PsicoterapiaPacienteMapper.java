package com.f_rafael.hospital_servicio.mapper;

import com.f_rafael.hospital_servicio.dto.PsicoterapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.PsicoterapiaPaciente;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class PsicoterapiaPacienteMapper {

    private IPacienteClient pacienteClient;

    public PsicoterapiaPacienteDto obtenerDto(PsicoterapiaPaciente informacionPsicoterapia){
        PsicoterapiaPacienteDto dtoARetornar = new PsicoterapiaPacienteDto();

        dtoARetornar.setId(informacionPsicoterapia.getId());
        dtoARetornar.setPaciente(pacienteClient.buscarPacientePorId(informacionPsicoterapia.getPacienteId()));
        dtoARetornar.setInicio(informacionPsicoterapia.getInicio());
        dtoARetornar.setFin(informacionPsicoterapia.getFin());

        return dtoARetornar;
    }

    public List<PsicoterapiaPacienteDto> obtenerListaDto(Collection<PsicoterapiaPaciente> informacionPsicoterapias){
        List<PsicoterapiaPacienteDto> listaParaRetornar = new LinkedList<>();

        for(PsicoterapiaPaciente pp : informacionPsicoterapias){
            listaParaRetornar.add(obtenerDto(pp));
        }

        return listaParaRetornar;
    }
}

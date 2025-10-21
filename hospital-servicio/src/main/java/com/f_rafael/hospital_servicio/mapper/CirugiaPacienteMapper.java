package com.f_rafael.hospital_servicio.mapper;

import com.f_rafael.hospital_servicio.dto.CirugiaPacienteDto;
import com.f_rafael.hospital_servicio.model.CirugiaPaciente;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class CirugiaPacienteMapper {

    private IPacienteClient pacienteClient;

    public CirugiaPacienteDto obtenerDto(CirugiaPaciente informacioncirugiaPaciente){
        CirugiaPacienteDto dtoARetornar = new CirugiaPacienteDto();

        dtoARetornar.setId(informacioncirugiaPaciente.getId());
        dtoARetornar.setPaciente(pacienteClient.obtenerInformacionPaciente(informacioncirugiaPaciente.getPacienteId()));
        dtoARetornar.setCirugia(informacioncirugiaPaciente.getCirugia());
        dtoARetornar.setFecha(informacioncirugiaPaciente.getFecha());
        dtoARetornar.setInicio(informacioncirugiaPaciente.getInicio());
        dtoARetornar.setFin(informacioncirugiaPaciente.getFin());

        return dtoARetornar;
    }

    public List<CirugiaPacienteDto> obtenerListaDto(Collection<CirugiaPaciente> informacionCirugiasPacientes){
        List<CirugiaPacienteDto> listaParaRetornar = new LinkedList<>();

        for(CirugiaPaciente cp : informacionCirugiasPacientes){
            listaParaRetornar.add(obtenerDto(cp));
        }

        return listaParaRetornar;
    }
}

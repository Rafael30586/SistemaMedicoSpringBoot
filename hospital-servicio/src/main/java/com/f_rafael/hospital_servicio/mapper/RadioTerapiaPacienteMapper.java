package com.f_rafael.hospital_servicio.mapper;

import com.f_rafael.hospital_servicio.dto.RadioTerapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.RadioTerapiaPaciente;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class RadioTerapiaPacienteMapper {

    private IPacienteClient pacienteClient;

    public RadioTerapiaPacienteDto obtenerDto(RadioTerapiaPaciente informacionTratamiento){
        RadioTerapiaPacienteDto dtoARetornar = new RadioTerapiaPacienteDto();

        dtoARetornar.setId(informacionTratamiento.getId());
        dtoARetornar.setPaciente(pacienteClient.buscarPorId(informacionTratamiento.getPacienteId()));
        dtoARetornar.setInicio(informacionTratamiento.getInicio());
        dtoARetornar.setFin(informacionTratamiento.getFin());

        return dtoARetornar;
    }

    public List<RadioTerapiaPacienteDto> obtenerListaDto(Collection<RadioTerapiaPaciente> informacionTratamientos){
        List<RadioTerapiaPacienteDto> listaParaRetornar = new LinkedList<>();

        for(RadioTerapiaPaciente rtp : informacionTratamientos){
            listaParaRetornar.add(obtenerDto(rtp));
        }

        return listaParaRetornar;
    }
}

package com.f_rafael.pacientes_servicio.utils;

import com.f_rafael.pacientes_servicio.dto.EstudioDto;
import com.f_rafael.pacientes_servicio.dto.SubPacienteDto;
import com.f_rafael.pacientes_servicio.dto.TurnoEstudioDto;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.model.TurnoEstudio;
import com.f_rafael.pacientes_servicio.repository.IEstudioClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Component
public class TurnoEstudioMap {

    private IEstudioClient estudioClient;
    private SubPacienteMap subPacienteMap;

    public TurnoEstudioDto obtenerDto(TurnoEstudio informacionTurno){
        TurnoEstudioDto dtoARetornar = new TurnoEstudioDto();
        Long estudioId = informacionTurno.getId();
        EstudioDto estudioParaAsignar;
        Paciente pacienteParaMapear = informacionTurno.getPaciente();
        SubPacienteDto pacienteParaAsignar;

        dtoARetornar.setId(informacionTurno.getId());
        dtoARetornar.setInicio(informacionTurno.getInicio());
        dtoARetornar.setFin(informacionTurno.getFin());
        dtoARetornar.setEstado(informacionTurno.getEstado());
        dtoARetornar.setFechaTurno(informacionTurno.getFechaTurno());
        dtoARetornar.setFechaSolicitud(informacionTurno.getFechaSolicitud());

        if(estudioId != null){
            estudioParaAsignar = estudioClient.obtenerInformacionEstudio(estudioId);
            dtoARetornar.setEstudio(estudioParaAsignar);
        }

        if(pacienteParaMapear != null){
            pacienteParaAsignar = subPacienteMap.obtenerDto(pacienteParaMapear);
            dtoARetornar.setPaciente(pacienteParaAsignar);
        }

        return dtoARetornar;
    }

    public List<TurnoEstudioDto> obtenerListaDto(Collection<TurnoEstudio> informacionTurnosEstudio){
        List<TurnoEstudioDto> listaARetornar = new LinkedList<>();

        for(TurnoEstudio te : informacionTurnosEstudio){
            listaARetornar.add(obtenerDto(te));
        }

        return listaARetornar;
    }
}

package com.f_rafael.pacientes_servicio.mapper;

import com.f_rafael.pacientes_servicio.dto.SubPacienteDto;
import com.f_rafael.pacientes_servicio.dto.TurnoCitaDto;
import com.f_rafael.pacientes_servicio.model.TurnoCita;
import com.f_rafael.pacientes_servicio.repository.IMedicoClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class TurnoCitaMapper {

    private IMedicoClient medicoClient;
    private SubPacienteMapper subPacienteMapper;

    public TurnoCitaDto obtenerDto(TurnoCita informacionTurno){
        TurnoCitaDto dtoARetornar = new TurnoCitaDto();
        SubPacienteDto pacienteParaAsignar;

        dtoARetornar.setId(informacionTurno.getId());
        dtoARetornar.setFechaTurno(informacionTurno.getFechaTurno());
        dtoARetornar.setInicio(informacionTurno.getInicio());
        dtoARetornar.setFin(informacionTurno.getFin());
        dtoARetornar.setEstado(informacionTurno.getEstado());
        dtoARetornar.setFechaSolicitud(informacionTurno.getFechaSolicitud());

        if(informacionTurno.getPaciente() != null){
            pacienteParaAsignar = subPacienteMapper.obtenerDto(informacionTurno.getPaciente());
            dtoARetornar.setPaciente(pacienteParaAsignar);
        }

        if(informacionTurno.getProfesionalId() != null){
            dtoARetornar.setMedico(medicoClient.obtenerInformacionMedico(informacionTurno.getProfesionalId()));
        }

        return dtoARetornar;
    }

    public List<TurnoCitaDto> obtenerListaDto(Collection<TurnoCita> informacionTurnosCita){
        List<TurnoCitaDto> listaARetornar = new LinkedList<>();

        for(TurnoCita tc : informacionTurnosCita){
            listaARetornar.add(obtenerDto(tc));
        }

        return listaARetornar;
    }
}

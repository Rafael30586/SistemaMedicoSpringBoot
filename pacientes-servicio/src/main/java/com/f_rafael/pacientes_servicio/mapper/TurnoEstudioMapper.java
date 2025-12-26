package com.f_rafael.pacientes_servicio.mapper;

import com.f_rafael.pacientes_servicio.dto.EstudioDto;
import com.f_rafael.pacientes_servicio.dto.SubPacienteDto;
import com.f_rafael.pacientes_servicio.dto.TurnoEstudioDto;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.model.TurnoEstudio;
import com.f_rafael.pacientes_servicio.repository.IEstudioClient;
import com.f_rafael.pacientes_servicio.repository.IHospitalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Component
public class TurnoEstudioMapper {

    // private IEstudioClient estudioClient;
    private SubPacienteMapper subPacienteMapper;
    private IHospitalClient hospitalClient;

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
            estudioParaAsignar = hospitalClient.obtenerEstudioPorId(estudioId);
            dtoARetornar.setEstudio(estudioParaAsignar);
        }

        if(pacienteParaMapear != null){
            pacienteParaAsignar = subPacienteMapper.obtenerDto(pacienteParaMapear);
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

package com.f_rafael.pacientes_servicio.mapper;

import com.f_rafael.pacientes_servicio.dto.ObraSocialDto;
import com.f_rafael.pacientes_servicio.dto.SubSedeDto;
import com.f_rafael.pacientes_servicio.dto.SubPacienteDto;
import com.f_rafael.pacientes_servicio.model.ObraSocial;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.model.Sede;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class ObraSocialMapper {

    SedeMapper sedeMapper;
    SubPacienteMapper subPacienteMapper;

    public ObraSocialDto obtenerDto(ObraSocial obraSocial){
        ObraSocialDto dtoARetornar = new ObraSocialDto();
        Set<Sede> informacionSedes;
        List<SubSedeDto> sedesParaAsignar;
        Set<Paciente> informacionPacientes;
        List<SubPacienteDto> pacientesParaAsignar;

        dtoARetornar.setId(obraSocial.getId());
        dtoARetornar.setNombre(obraSocial.getNombre());

        if(obraSocial.getSedes() != null){
            informacionSedes = obraSocial.getSedes();

            sedesParaAsignar = sedeMapper.obtenerListaDtos(informacionSedes);
            dtoARetornar.setSedes(sedesParaAsignar);
        }

        if(obraSocial.getPacientes() != null){
            informacionPacientes = obraSocial.getPacientes();

            pacientesParaAsignar = subPacienteMapper.obtenerListaDto(informacionPacientes);
            dtoARetornar.setPacientes(pacientesParaAsignar);
        }

        return dtoARetornar;
    }

    public List<ObraSocialDto> obtenerListaDto(Collection<ObraSocial> informacionObrasSociales){
        List<ObraSocialDto> listaARetornar = new LinkedList<>();

        for(ObraSocial os : informacionObrasSociales){
            listaARetornar.add(obtenerDto(os));
        }

        return listaARetornar;
    }
}

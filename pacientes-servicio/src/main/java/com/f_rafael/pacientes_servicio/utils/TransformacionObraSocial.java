package com.f_rafael.pacientes_servicio.utils;

import com.f_rafael.pacientes_servicio.dto.ObraSocialDto;
import com.f_rafael.pacientes_servicio.dto.SedeDto;
import com.f_rafael.pacientes_servicio.dto.SubPacienteDto;
import com.f_rafael.pacientes_servicio.model.ObraSocial2;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.model.Sede;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class TransformacionObraSocial {

    TransformacionSede transformacionSede;
    TransformacionSubPaciente transformacionSubPaciente;

    public ObraSocialDto obtenerDto(ObraSocial2 obraSocial){
        ObraSocialDto dtoARetornar = new ObraSocialDto();
        Set<Sede> informacionSedes;
        List<SedeDto> sedesParaAsignar;
        Set<Paciente> informacionPacientes;
        List<SubPacienteDto> pacientesParaAsignar;

        dtoARetornar.setId(obraSocial.getId());
        dtoARetornar.setNombre(obraSocial.getNombre());

        if(obraSocial.getSedes() != null){
            informacionSedes = obraSocial.getSedes();

            sedesParaAsignar = transformacionSede.obtenerListaDtos(informacionSedes);
            dtoARetornar.setSedes(sedesParaAsignar);
        }

        if(obraSocial.getPacientes() != null){
            informacionPacientes = obraSocial.getPacientes();

            pacientesParaAsignar = transformacionSubPaciente.obtenerListaDto(informacionPacientes);
            dtoARetornar.setPacientes(pacientesParaAsignar);
        }

        return dtoARetornar;
    }
}

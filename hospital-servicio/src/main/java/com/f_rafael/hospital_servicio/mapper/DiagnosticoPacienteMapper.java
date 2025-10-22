package com.f_rafael.hospital_servicio.mapper;

import com.f_rafael.hospital_servicio.dto.DiagnosticoPacienteDto;
import com.f_rafael.hospital_servicio.model.DiagnosticoPaciente;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Component
public class DiagnosticoPacienteMapper {

    private IPacienteClient pacienteClient;

    public DiagnosticoPacienteDto obtenerDto(DiagnosticoPaciente informacionDiagnosticoPaciente){
        DiagnosticoPacienteDto dtoARetornar = new DiagnosticoPacienteDto();

        dtoARetornar.setId(informacionDiagnosticoPaciente.getId());
        dtoARetornar.setPaciente(pacienteClient.buscarPorId(informacionDiagnosticoPaciente.getPacienteId()));
        dtoARetornar.setDiagnostico(informacionDiagnosticoPaciente.getDiagnostico().getNombre());
        dtoARetornar.setInicio(informacionDiagnosticoPaciente.getInicio());
        dtoARetornar.setFin(informacionDiagnosticoPaciente.getFin());

        return dtoARetornar;
    }

    public List<DiagnosticoPacienteDto> obtenerListaDto(Collection<DiagnosticoPaciente> informacionDiagnosticosPacientes){
        List<DiagnosticoPacienteDto> listaParaRetornar = new LinkedList<>();

        for(DiagnosticoPaciente dp : informacionDiagnosticosPacientes){
            listaParaRetornar.add(obtenerDto(dp));
        }

        return  listaParaRetornar;
    }
}

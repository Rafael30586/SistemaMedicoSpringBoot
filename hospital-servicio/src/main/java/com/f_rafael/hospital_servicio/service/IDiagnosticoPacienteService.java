package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.DiagnosticoPacienteDto;
import com.f_rafael.hospital_servicio.model.DiagnosticoPaciente;

import java.util.List;

public interface IDiagnosticoPacienteService {

    public DiagnosticoPacienteDto buscarPorId(Long id);
    public List<DiagnosticoPacienteDto> buscarTodos();
    public DiagnosticoPacienteDto guardar(DiagnosticoPaciente diagnosticoPaciente);
    public DiagnosticoPacienteDto actualizar(DiagnosticoPaciente diagnosticoPaciente);
    public void borrarPorId(Long id);
    public List<DiagnosticoPacienteDto> buscarPorPaciente(Long idODni,String opcion);
    public List<DiagnosticoPacienteDto> buscarPorDiagnostico(String diagnostico);
}

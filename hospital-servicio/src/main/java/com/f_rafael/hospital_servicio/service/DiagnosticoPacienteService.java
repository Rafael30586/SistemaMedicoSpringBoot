package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.DiagnosticoPacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.DiagnosticoPacienteMapper;
import com.f_rafael.hospital_servicio.model.DiagnosticoPaciente;
import com.f_rafael.hospital_servicio.repository.IDiagnosticoPacienteRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiagnosticoPacienteService implements IDiagnosticoPacienteService{

    private DiagnosticoPacienteMapper mapper;
    private IDiagnosticoPacienteRepository repository;

    @Override
    public DiagnosticoPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Diagnóstico para paciente no encontrado")));
    }

    @Override
    public List<DiagnosticoPacienteDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public DiagnosticoPacienteDto guardar(DiagnosticoPaciente diagnosticoPaciente) {

        if(diagnosticoPaciente.getPacienteId() == null || diagnosticoPaciente.getDiagnostico() == null || diagnosticoPaciente.getInicio() == null){
            throw new CampoNuloException("Algunos campos de diagnóstico para paciente no pueden ser nulos");
        }

        return mapper.obtenerDto(repository.save(diagnosticoPaciente));
    }

    @Override
    public DiagnosticoPacienteDto actualizar(DiagnosticoPaciente diagnosticoPaciente) {
        return this.guardar(diagnosticoPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El id no corresponde a ningún diagnóstico para paciente");
        }

        repository.deleteById(id);
    }
}

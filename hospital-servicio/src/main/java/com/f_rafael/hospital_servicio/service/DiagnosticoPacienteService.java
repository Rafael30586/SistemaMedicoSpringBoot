package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.DiagnosticoPacienteDto;
import com.f_rafael.hospital_servicio.dto.PacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.DiagnosticoPacienteMapper;
import com.f_rafael.hospital_servicio.model.Diagnostico;
import com.f_rafael.hospital_servicio.model.DiagnosticoPaciente;
import com.f_rafael.hospital_servicio.repository.IDiagnosticoPacienteRepository;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class DiagnosticoPacienteService implements IDiagnosticoPacienteService{

    private DiagnosticoPacienteMapper mapper;
    private IDiagnosticoPacienteRepository repository;
    private Verificador verificador;
    private IPacienteClient pacienteClient;

    @Override
    public DiagnosticoPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(devolverPorId(id));
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

        if(diagnosticoPaciente.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }
        return this.guardar(diagnosticoPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El id no corresponde a ningún diagnóstico para paciente");
        }

        repository.deleteById(id);
    }

    @Override
    public List<DiagnosticoPacienteDto> buscarPorPaciente(Long idODni, String opcion) {
        List<DiagnosticoPacienteDto> listaParaRetornar = new LinkedList<>();
        List<DiagnosticoPaciente> informacionDiagnosticos;
        PacienteDto informacionPaciente;

        verificador.esIdODni(opcion);

        if(opcion.equals("id")){
            listaParaRetornar = mapper.obtenerListaDto(repository.buscarPorPaciente(idODni));
            System.gc();
        }

        if(opcion.equals("dni")){
            informacionDiagnosticos = repository.findAll();
            informacionPaciente = pacienteClient.buscarPorDni(idODni);

            for(DiagnosticoPaciente dp : informacionDiagnosticos){
                if(dp.getPacienteId().equals(informacionPaciente.getId())){
                    listaParaRetornar.add(mapper.obtenerDto(dp));
                }
            }
        }
        return listaParaRetornar;
    }

    @Override
    public List<DiagnosticoPacienteDto> buscarPorDiagnostico(String diagnostico) {
        return mapper.obtenerListaDto(repository.buscarPorDiagnostico(diagnostico));
    }

    @Override
    public DiagnosticoPacienteDto modificarPaciente(Long id, Long idODniPaciente, String opcion) {
        DiagnosticoPaciente diagnosticoParaActualizar = devolverPorId(id);


        verificador.esIdODni(opcion);

        if(opcion.equals("id")){
            diagnosticoParaActualizar.setPacienteId(idODniPaciente);
        }

        if(opcion.equals("dni")){
            diagnosticoParaActualizar.setPacienteId(pacienteClient.buscarPorDni(idODniPaciente).getId());
        }

        return this.actualizar(diagnosticoParaActualizar);
    }

    @Override
    public DiagnosticoPacienteDto modificarDiagnostico(Long id, Long diagnosticoId) {
        DiagnosticoPaciente diagnosticoParaActualizar = devolverPorId(id);

        Diagnostico diagnosticoParaAsignar = new Diagnostico();
        diagnosticoParaAsignar.setId(diagnosticoId);

        diagnosticoParaActualizar.setDiagnostico(diagnosticoParaAsignar);

        return this.actualizar(diagnosticoParaActualizar);
    }

    @Override
    public DiagnosticoPacienteDto modificarFechaDeInicio(Long id, LocalDate inicio) {
        DiagnosticoPaciente diagnosticoParaActualizar = devolverPorId(id);
        verificador.esAnterior(inicio,diagnosticoParaActualizar.getFin());
        diagnosticoParaActualizar.setInicio(inicio);

        return this.actualizar(diagnosticoParaActualizar);
    }

    @Override
    public DiagnosticoPacienteDto modificarFechaFinal(Long id, LocalDate fin) {
        DiagnosticoPaciente diagnosticoParaActualizar = devolverPorId(id);
        verificador.esAnterior(diagnosticoParaActualizar.getInicio(), fin);
        diagnosticoParaActualizar.setFin(fin);

        return this.actualizar(diagnosticoParaActualizar);
    }

    public DiagnosticoPaciente devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Diagnóstico para paciente no encontrado"));
    }
}

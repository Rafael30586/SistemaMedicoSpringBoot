package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.dto.DiagnosticoPacienteDto;
import com.f_rafael.hospital_servicio.model.DiagnosticoPaciente;
import com.f_rafael.hospital_servicio.service.IDiagnosticoPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/diagnosticos-pacientes")
@AllArgsConstructor
public class DiagnosticoPacienteController {
    private IDiagnosticoPacienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosticoPacienteDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<DiagnosticoPacienteDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<List<DiagnosticoPacienteDto>> buscarPorPaciente(@RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                    @RequestParam String opcion){
        return ResponseEntity.ok(service.buscarPorPaciente(pacienteIdODni, opcion));
    }

    @GetMapping
    public ResponseEntity<List<DiagnosticoPacienteDto>> buscarPorDiagnostico(@RequestParam String diagnostico){
        return ResponseEntity.ok(service.buscarPorDiagnostico(diagnostico));
    }

    @PostMapping
    public ResponseEntity<DiagnosticoPacienteDto> guardar(@RequestBody DiagnosticoPaciente diagnosticoPaciente){
        return new ResponseEntity<>(service.guardar(diagnosticoPaciente), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<DiagnosticoPacienteDto> actualizar(@RequestBody DiagnosticoPaciente diagnosticoPaciente){
        return ResponseEntity.ok(service.actualizar(diagnosticoPaciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("El diagnóstico para paciente ha sido borrado",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DiagnosticoPacienteDto> modificarPaciente(@PathVariable Long id,
                                                                    @RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                    @RequestParam String opcion){
        return ResponseEntity.ok(service.modificarPaciente(id, pacienteIdODni, opcion));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DiagnosticoPacienteDto> modificarDiagnostico(@PathVariable Long id,
                                                                       @RequestParam("diagnostico-id") Long diagnosticoId){
        return ResponseEntity.ok(service.modificarDiagnostico(id, diagnosticoId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DiagnosticoPacienteDto> modificarFechaDeInicio(@PathVariable Long id,
                                                                         @RequestParam LocalDate inicio){
        return ResponseEntity.ok(service.modificarFechaDeInicio(id, inicio));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DiagnosticoPacienteDto> modificarFechaDeFinal(@PathVariable Long id,
                                                                        @RequestParam LocalDate fin){
        return ResponseEntity.ok(service.modificarFechaFinal(id, fin));
    }
}

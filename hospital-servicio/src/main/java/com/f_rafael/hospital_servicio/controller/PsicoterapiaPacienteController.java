package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.dto.PsicoterapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.PsicoterapiaPaciente;
import com.f_rafael.hospital_servicio.service.PsicoterapiaPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/psicoterapias-pacientes")
@AllArgsConstructor
public class PsicoterapiaPacienteController {

    private PsicoterapiaPacienteService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<PsicoterapiaPacienteDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<PsicoterapiaPacienteDto>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/paciente") // funciona
    public ResponseEntity<List<PsicoterapiaPacienteDto>> buscarPorPaciente(@RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                           @RequestParam String opcion) {
        return ResponseEntity.ok(service.buscarPorPaciente(pacienteIdODni, opcion));
    }

    @GetMapping("/fecha-inicio") // funciona
    public ResponseEntity<List<PsicoterapiaPacienteDto>> buscarPorFechaDeInicio(@RequestParam LocalDate desde,
                                                                                @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorFechaDeInicio(desde, hasta));
    }

    @GetMapping("/fecha-final") // funciona
    public ResponseEntity<List<PsicoterapiaPacienteDto>> buscarPorFechaDeFinal(@RequestParam LocalDate desde,
                                                                               @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorFechaDeFinal(desde,hasta));
    }

    @PostMapping // funciona
    public ResponseEntity<PsicoterapiaPacienteDto> guardar(@RequestBody PsicoterapiaPaciente psicoterapiaPaciente){
        return new ResponseEntity<>(service.guardar(psicoterapiaPaciente), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<PsicoterapiaPacienteDto> actualizar(@RequestBody PsicoterapiaPaciente psicoterapiaPaciente){
        return ResponseEntity.ok(service.actualizar(psicoterapiaPaciente));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("El tratamiento ha sido borrado", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/paciente") // funciona
    public ResponseEntity<PsicoterapiaPacienteDto> modificarPaciente(@PathVariable Long id,
                                                                     @RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                     @RequestParam String opcion){
        return ResponseEntity.ok(service.modificarPaciente(id, pacienteIdODni, opcion));
    }

    @PatchMapping("/{id}/fecha-inicio") // funciona
    public ResponseEntity<PsicoterapiaPacienteDto> modificarFechaDeInicio(@PathVariable Long id,
                                                                          @RequestParam LocalDate inicio){
        return ResponseEntity.ok(service.modificarFechaDeInicio(id,inicio));
    }

    @PatchMapping("/{id}/fecha-final") // funciona
    public ResponseEntity<PsicoterapiaPacienteDto> modificarFechaDeFinal(@PathVariable Long id,
                                                                         @RequestParam LocalDate fin){
        return ResponseEntity.ok(service.modificarFechaDeFinal(id,fin));
    }


}

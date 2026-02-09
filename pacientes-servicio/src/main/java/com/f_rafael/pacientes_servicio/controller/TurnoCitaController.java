package com.f_rafael.pacientes_servicio.controller;

import com.f_rafael.pacientes_servicio.dto.TurnoCitaDto;
import com.f_rafael.pacientes_servicio.model.TurnoCita;
import com.f_rafael.pacientes_servicio.service.ITurnoCitaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/turnos-cita")
@AllArgsConstructor
public class TurnoCitaController {

    private ITurnoCitaService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<TurnoCitaDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<TurnoCitaDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/paciente") // funciona
    public ResponseEntity<List<TurnoCitaDto>> buscarPorPaciente(@RequestParam Long dni){
        return ResponseEntity.ok(service.buscarPorPaciente(dni));
    }

    @GetMapping("/fecha-turno") // funciona
    public ResponseEntity<List<TurnoCitaDto>> buscarPorFechaTurno(@RequestParam("fecha-turno") LocalDate fechaTurno){
        return ResponseEntity.ok(service.buscarPorFechaTurno(fechaTurno));
    }

    @GetMapping("/periodo") // funciona
    public ResponseEntity<List<TurnoCitaDto>> buscarPorPeriodo(@RequestParam LocalDate desde,
                                                               @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorPeriodo(desde,hasta));
    }

    @GetMapping("/estado") // funciona
    public ResponseEntity<List<TurnoCitaDto>> buscarPorEstado(@RequestParam String estado){
        return ResponseEntity.ok(service.buscarPorEstado(estado));
    }

    @GetMapping("/profesional") // funciona
    public ResponseEntity<List<TurnoCitaDto>> buscarPorProfesional(@RequestParam("profesional-id") Long profesionalId){
        return ResponseEntity.ok(service.buscarPorProfesional(profesionalId));
    }

    @PostMapping // funciona
    public ResponseEntity<TurnoCitaDto> guardar(@RequestBody TurnoCita turnoCita){
        return new ResponseEntity<>(service.guardar(turnoCita), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<TurnoCitaDto> actualizar(@RequestBody TurnoCita turnoCita){
        return ResponseEntity.ok(service.actualizar(turnoCita));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/paciente") // funciona
    public ResponseEntity<TurnoCitaDto> actualizarPaciente(@PathVariable Long id,
                                                           @RequestParam("id-o-dni-paciente") Long idODniPaciente,
                                                           @RequestParam String opcion){
        return ResponseEntity.ok(service.actualizarPaciente(id,idODniPaciente,opcion));
    }

    @PatchMapping("/{id}/fecha-solicitud") // funciona
    public ResponseEntity<TurnoCitaDto> actualizarFechaSolicitud(@PathVariable Long id,
                                                                 @RequestParam("fecha-solicitud") LocalDate fechaSolicitud){
        return ResponseEntity.ok(service.actualizarFechaSolicitud(id,fechaSolicitud));
    }

    @PatchMapping("/{id}/horario") // funciona
    public ResponseEntity<TurnoCitaDto> actualizarHorario(@PathVariable Long id,
                                                          @RequestParam LocalTime inicio,
                                                          @RequestParam LocalTime fin){
        return ResponseEntity.ok(service.actualizarHorario(id,inicio,fin));
    }

    @PatchMapping("/{id}/estado") // funciona
    public ResponseEntity<TurnoCitaDto> actualizarEstado(@PathVariable Long id,
                                                         @RequestParam String estado){
        return ResponseEntity.ok(service.actualizarEstado(id,estado));
    }

    @PatchMapping("/{id}/cobertura") // funciona
    public ResponseEntity<TurnoCitaDto> actualizarCobertura(@PathVariable Long id,
                                                             @RequestParam String cobertura){
        return ResponseEntity.ok(service.actualizarCobertura(id,cobertura));
    }
}

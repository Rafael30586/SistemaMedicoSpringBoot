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

    @GetMapping("/{id}")
    public ResponseEntity<TurnoCitaDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TurnoCitaDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<List<TurnoCitaDto>> buscarPorPaciente(@RequestParam Long dni){
        return ResponseEntity.ok(service.buscarPorPaciente(dni));
    }

    @GetMapping
    public ResponseEntity<List<TurnoCitaDto>> buscarPorFechaTurno(@RequestParam LocalDate fechaTurno){
        return ResponseEntity.ok(service.buscarPorFechaTurno(fechaTurno));
    }

    @GetMapping
    public ResponseEntity<List<TurnoCitaDto>> buscarPorPeriodo(@RequestParam LocalDate desde,
                                                               @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorPeriodo(desde,hasta));
    }

    @GetMapping
    public ResponseEntity<List<TurnoCitaDto>> buscarPorEstado(@RequestParam String estado){
        return ResponseEntity.ok(service.buscarPorEstado(estado));
    }

    @GetMapping
    public ResponseEntity<List<TurnoCitaDto>> buscarPorProfesional(@RequestParam Long id){
        return ResponseEntity.ok(service.buscarPorProfesional(id));
    }

    @PostMapping
    public ResponseEntity<TurnoCitaDto> guardar(@RequestBody TurnoCita turnoCita){
        return new ResponseEntity<>(service.guardar(turnoCita), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<TurnoCitaDto> actualizar(@RequestBody TurnoCita turnoCita){
        return ResponseEntity.ok(service.actualizar(turnoCita));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping
    public ResponseEntity<TurnoCitaDto> actualizarPaciente(@RequestParam Long id,
                                                           @RequestParam("id-o-dni-paciente") Long idODniPaciente,
                                                           @RequestParam String opcion){
        return ResponseEntity.ok(service.actualizarPaciente(id,idODniPaciente,opcion));
    }

    @PatchMapping
    public ResponseEntity<TurnoCitaDto> actualizarFechaSolicitud(@RequestParam Long id,
                                                                 @RequestParam("fecha-solicitud") LocalDate fechaSolicitud){
        return ResponseEntity.ok(service.actualizarFechaSolicitud(id,fechaSolicitud));
    }

    @PatchMapping
    public ResponseEntity<TurnoCitaDto> actualizarHorario(@RequestParam Long id,
                                                          @RequestParam LocalTime inicio,
                                                          @RequestParam LocalTime fin){
        return ResponseEntity.ok(service.actualizarHorario(id,inicio,fin));
    }

    @PatchMapping
    public ResponseEntity<TurnoCitaDto> actualizarEstado(@RequestParam Long id,
                                                         @RequestParam String estado){
        return ResponseEntity.ok(service.actualizarEstado(id,estado));
    }

    @PatchMapping
    public ResponseEntity<TurnoCitaDto> actualizarCobertura(@RequestParam Long id,
                                                             @RequestParam String cobertura){
        return ResponseEntity.ok(service.actualizarCobertura(id,cobertura));
    }
}

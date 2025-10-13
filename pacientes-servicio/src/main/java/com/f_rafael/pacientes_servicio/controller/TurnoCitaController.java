package com.f_rafael.pacientes_servicio.controller;

import com.f_rafael.pacientes_servicio.dto.TurnoCitaDto;
import com.f_rafael.pacientes_servicio.model.TurnoCita;
import com.f_rafael.pacientes_servicio.service.ITurnoCitaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
}

package com.f_rafael.pacientes_servicio.controller;

import com.f_rafael.pacientes_servicio.dto.TurnoEstudioDto;
import com.f_rafael.pacientes_servicio.model.TurnoEstudio;
import com.f_rafael.pacientes_servicio.service.ITurnoEstudioService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/turnos-estudio")
@AllArgsConstructor
public class TurnoEstudioController {

    private ITurnoEstudioService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<TurnoEstudioDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<TurnoEstudioDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/paciente") // funciona
    public ResponseEntity<List<TurnoEstudioDto>> buscarPorPaciente(@RequestParam Long dni){
        return ResponseEntity.ok(service.buscarPorPaciente(dni));
    }

    @GetMapping("/fecha-turno") // funciona
    public ResponseEntity<List<TurnoEstudioDto>> buscarPorFechaTurno(@RequestParam("fecha-turno") LocalDate fechaTurno){
        return ResponseEntity.ok(service.buscarPorFechaTurno(fechaTurno));
    }

    @GetMapping("/periodo") // funciona
    public ResponseEntity<List<TurnoEstudioDto>> buscarPorPeriodo(@RequestParam LocalDate desde,
                                                                  @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorPeriodo(desde,hasta));
    }

    @GetMapping("/estado") // funciona
    public ResponseEntity<List<TurnoEstudioDto>> buscarPorEstado(@RequestParam String estado){
        return ResponseEntity.ok(service.buscarPorEstado(estado));
    }

    @GetMapping("/estudio") // funciona
    public ResponseEntity<List<TurnoEstudioDto>> buscarPorEstudio(@RequestParam("estudio-id") Long estudioId){
        return ResponseEntity.ok(service.buscarPorEstudioId(estudioId));
    }

    @PostMapping // funciona
    public ResponseEntity<TurnoEstudioDto> guardar(@RequestBody TurnoEstudio turnoEstudio){
        return new ResponseEntity<>(service.guardar(turnoEstudio), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<TurnoEstudioDto> actualizar(@RequestBody TurnoEstudio turnoEstudio){
        return ResponseEntity.ok(service.actualizar(turnoEstudio));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/paciente") // funciona
    public ResponseEntity<TurnoEstudioDto> actualizarPaciente(@PathVariable Long id,
                                                              @RequestParam("id-o-dni-paciente") Long idODniPaciente,
                                                              @RequestParam String opcion){
        return ResponseEntity.ok(service.actualizarPaciente(id,idODniPaciente,opcion));
    }

    @PatchMapping("/{id}/fecha-solicitud") // funciona
    public ResponseEntity<TurnoEstudioDto> actualizarFechaSolicitud(@PathVariable Long id,
                                                                    @RequestParam("fecha-solicitud") LocalDate fechaSolicitud){
        return ResponseEntity.ok(service.actualizarFechaSolicitud(id,fechaSolicitud));
    }

    @PatchMapping("/{id}/fecha-turno") // funciona
    public ResponseEntity<TurnoEstudioDto> actualizarFechaTurno(@PathVariable Long id,
                                                                @RequestParam("fecha-turno") LocalDate fechaTurno){
        return ResponseEntity.ok(service.actualizarFechaTurno(id,fechaTurno));
    }

    @PatchMapping("/{id}/horario") // funciona
    public ResponseEntity<TurnoEstudioDto> actualizarHorario(@PathVariable Long id,
                                                             @RequestParam LocalTime inicio,
                                                             @RequestParam LocalTime fin){
        return ResponseEntity.ok(service.actualizarHorario(id,inicio,fin));
    }

    @PatchMapping("/{id}/estado") // funciona
    public ResponseEntity<TurnoEstudioDto> actualizarEstado(@PathVariable Long id,
                                                            @RequestParam String estado){
        return ResponseEntity.ok(service.actualizarEstado(id,estado));
    }

    @PatchMapping("/{id}/cobertura") // funciona
    public ResponseEntity<TurnoEstudioDto> actualizarCobertura(@PathVariable Long id,
                                                               @RequestParam String cobertura){
        return ResponseEntity.ok(service.actualizarCobertura(id,cobertura));
    }

    @PatchMapping("/{id}/estudio") // funciona
    public ResponseEntity<TurnoEstudioDto> actualizarEstudio(@PathVariable Long id,
                                                             @RequestParam("estudio-id") Long estudioId){
        return ResponseEntity.ok(service.actualizarEstudio(id,estudioId));
    }
}

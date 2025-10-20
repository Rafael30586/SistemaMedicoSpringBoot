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

    @GetMapping("/{id}")
    public ResponseEntity<TurnoEstudioDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TurnoEstudioDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<List<TurnoEstudioDto>> buscarPorPaciente(@RequestParam Long dni){
        return ResponseEntity.ok(service.buscarPorPaciente(dni));
    }

    @GetMapping
    public ResponseEntity<List<TurnoEstudioDto>> buscarPorFechaTurno(@RequestParam LocalDate fechaTurno){
        return ResponseEntity.ok(service.buscarPorFechaTurno(fechaTurno));
    }

    @GetMapping
    public ResponseEntity<List<TurnoEstudioDto>> buscarPorEstado(@RequestParam String estado){
        return ResponseEntity.ok(service.buscarPorEstado(estado));
    }

    @GetMapping
    public ResponseEntity<List<TurnoEstudioDto>> buscarPorEstudio(@RequestParam("estudio-id") Long estudioId){
        return ResponseEntity.ok(service.buscarPorEstudioId(estudioId));
    }

    @PostMapping
    public ResponseEntity<TurnoEstudioDto> guardar(@RequestBody TurnoEstudio turnoEstudio){
        return new ResponseEntity<>(service.guardar(turnoEstudio), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<TurnoEstudioDto> actualizar(@RequestBody TurnoEstudio turnoEstudio){
        return ResponseEntity.ok(service.actualizar(turnoEstudio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping
    public ResponseEntity<TurnoEstudioDto> actualziarPaciente(@RequestParam Long id,
                                                              @RequestParam("id-o-dni-paciente") Long idODniPaciente,
                                                              @RequestParam String opcion){
        return ResponseEntity.ok(service.actualizarPaciente(id,idODniPaciente,opcion));
    }

    @PatchMapping
    public ResponseEntity<TurnoEstudioDto> actualizarFechaSolicitud(@RequestParam Long id,
                                                                    @RequestParam("fecha-solicitud") LocalDate fechaSolicitud){
        return ResponseEntity.ok(service.actualizarFechaSolicitud(id,fechaSolicitud));
    }

    @PatchMapping
    public ResponseEntity<TurnoEstudioDto> actualizarFechaTurno(@RequestParam Long id,
                                                                @RequestParam LocalDate fechaTurno){
        return ResponseEntity.ok(service.actualizarFechaTurno(id,fechaTurno));
    }

    @PatchMapping
    public ResponseEntity<TurnoEstudioDto> actualizarHorario(@RequestParam Long id,
                                                             @RequestParam LocalTime inicio,
                                                             @RequestParam LocalTime fin){
        return ResponseEntity.ok(service.actualizarHorario(id,inicio,fin));
    }

    @PatchMapping
    public ResponseEntity<TurnoEstudioDto> actualizarEstado(@RequestParam Long id,
                                                            @RequestParam String estado){
        return ResponseEntity.ok(service.actualizarEstado(id,estado));
    }

    @PatchMapping
    public ResponseEntity<TurnoEstudioDto> actualizarCobertura(@RequestParam Long id,
                                                               @RequestParam String cobertura){
        return ResponseEntity.ok(service.actualizarCobertura(id,cobertura));
    }

    @PatchMapping
    public ResponseEntity<TurnoEstudioDto> actualizarEstudio(@RequestParam Long id,
                                                             @RequestParam("estudio-id") Long estudioId){
        return ResponseEntity.ok(service.actualizarEstudio(id,estudioId));
    }
}

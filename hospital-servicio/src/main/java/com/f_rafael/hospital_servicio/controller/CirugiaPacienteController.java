package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.dto.CirugiaPacienteDto;
import com.f_rafael.hospital_servicio.model.CirugiaPaciente;
import com.f_rafael.hospital_servicio.service.ICirugiaPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/cirugia-paciente")
@AllArgsConstructor
public class CirugiaPacienteController {

    private ICirugiaPacienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<CirugiaPacienteDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<CirugiaPacienteDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping
    public ResponseEntity<List<CirugiaPacienteDto>> buscarPorPaciente(@RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                      @RequestParam String opcion){
        return ResponseEntity.ok(service.buscarPorPaciente(pacienteIdODni,opcion));
    }

    @GetMapping
    public ResponseEntity<List<CirugiaPacienteDto>> buscarPorCirugia(@RequestParam String cirugia){
        return ResponseEntity.ok(service.buscarPorCirugia(cirugia));
    }

    @GetMapping
    public ResponseEntity<List<CirugiaPacienteDto>> buscarPorPeriodo(@RequestParam LocalDate desde,
                                                                     @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorPeriodo(desde, hasta));
    }

    @PostMapping
    public ResponseEntity<CirugiaPacienteDto> guardar(@RequestBody CirugiaPaciente cirugiaPaciente){
        return new ResponseEntity<>(service.guardar(cirugiaPaciente), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<CirugiaPacienteDto> actualizar(@RequestBody CirugiaPaciente cirugiaPaciente){
        return ResponseEntity.ok(service.actualizar(cirugiaPaciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Cirugía en paciente borrada", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CirugiaPacienteDto> modificarPaciente(@PathVariable Long id,
                                                                @RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                @RequestParam String opcion){
        return ResponseEntity.ok(service.modificarPaciente(id, pacienteIdODni, opcion));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CirugiaPacienteDto> modificarCirugia(@PathVariable Long id,
                                                               @RequestParam("cirugia-id") Long cirugiaId){
        return ResponseEntity.ok(service.modificarCirugia(id,cirugiaId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CirugiaPacienteDto> modificarFecha(@PathVariable Long id,
                                                             @RequestParam LocalDate fecha){
        return ResponseEntity.ok(service.modificarFecha(id,fecha));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CirugiaPacienteDto> modificarHoraDeInicio(@PathVariable Long id,
                                                                    @RequestParam LocalTime inicio){
        return ResponseEntity.ok(service.modificarHoraInicio(id,inicio));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CirugiaPacienteDto> modificarHoraDeFinal(@PathVariable Long id,
                                                                   @RequestParam LocalTime fin){
        return ResponseEntity.ok(service.modificarHoraFinal(id, fin));
    }
}

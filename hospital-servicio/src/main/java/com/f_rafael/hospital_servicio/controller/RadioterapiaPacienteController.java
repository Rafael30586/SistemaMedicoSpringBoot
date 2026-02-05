package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.dto.RadioTerapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.RadioterapiaPaciente;
import com.f_rafael.hospital_servicio.service.IRadioterapiaPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/radioterapias-pacientes")
public class RadioterapiaPacienteController {

    private IRadioterapiaPacienteService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<RadioTerapiaPacienteDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<RadioTerapiaPacienteDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/paciente") // funciona
    public ResponseEntity<List<RadioTerapiaPacienteDto>> buscarPorPaciente(@RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                           @RequestParam String opcion){
        return ResponseEntity.ok(service.buscarPorPaciente(pacienteIdODni, opcion));
    }

    @GetMapping("/fecha-inicio") // funciona
    public ResponseEntity<List<RadioTerapiaPacienteDto>> buscaPorFechaDeInicio(@RequestParam LocalDate desde,
                                                                               @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorFechaInicio(desde,hasta));
    }

    @GetMapping("/fecha-final") // funciona
    public ResponseEntity<List<RadioTerapiaPacienteDto>> buscarPorFechaDeFinal(@RequestParam LocalDate desde,
                                                                               @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorFechaFinal(desde, hasta));
    }

    @PostMapping // funciona
    public ResponseEntity<RadioTerapiaPacienteDto> guardar(@RequestBody RadioterapiaPaciente radioterapiaPaciente){
        return new ResponseEntity<>(service.guardar(radioterapiaPaciente), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<RadioTerapiaPacienteDto> actualizar(@RequestBody RadioterapiaPaciente radioterapiaPaciente){
        return ResponseEntity.ok(service.actualizar(radioterapiaPaciente));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("El tratamiento ha sido borrado", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/paciente") // funciona
    public ResponseEntity<RadioTerapiaPacienteDto> modificarPaciente(@PathVariable Long id,
                                                                     @RequestParam("paciente-id-o-dni") Long pacidenteIdODni,
                                                                     @RequestParam String opcion){
        return ResponseEntity.ok(service.modificarPaciente(id, pacidenteIdODni, opcion));
    }

    @PatchMapping("/{id}/fecha-inicio") // funciona
    public ResponseEntity<RadioTerapiaPacienteDto> modificarFechaDeInicio(@PathVariable Long id,
                                                                          @RequestParam LocalDate inicio){
        return ResponseEntity.ok(service.modificarFechaDeInicio(id, inicio));
    }

    @PatchMapping("/{id}/fecha-final") // funciona
    public ResponseEntity<RadioTerapiaPacienteDto> modificarFechaDeFinal(@PathVariable Long id,
                                                                         @RequestParam LocalDate fin){
        return ResponseEntity.ok(service.modificarFechaDeFinal(id, fin));
    }
}

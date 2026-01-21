package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.dto.FisioterapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.FisioterapiaPaciente;
import com.f_rafael.hospital_servicio.repository.IFisioterapiaPacienteRepository;
import com.f_rafael.hospital_servicio.service.IFisioterapiaPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/fisioterapias-pacientes")
@AllArgsConstructor
public class FisioterapiaPacienteController {

    private IFisioterapiaPacienteService service;
    private IFisioterapiaPacienteRepository repository; // atributo para hacer pruebas

    @GetMapping("/{id}") // funciona
    public ResponseEntity<FisioterapiaPacienteDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<FisioterapiaPacienteDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/todas") // método para hacer pruebas
    public List<FisioterapiaPaciente> buscarToditas(){
        return repository.findAll();
    }

    @GetMapping("/paciente")
    public ResponseEntity<List<FisioterapiaPacienteDto>> buscarPorPaciente(@RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                     @RequestParam String opcion){
        return ResponseEntity.ok(service.buscarPorPaciente(pacienteIdODni, opcion));
    }

    @GetMapping("/fecha-inicio")
    public ResponseEntity<List<FisioterapiaPacienteDto>> buscarPorFechaDeInicio(@RequestParam LocalDate desde,
                                                                                @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorFechaDeInicio(desde, hasta));
    }

    @GetMapping("/fecha-final")
    public ResponseEntity<List<FisioterapiaPacienteDto>> buscarPorFechaDeFinal(@RequestParam LocalDate desde,
                                                                               @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorFechaDeFinal(desde, hasta));
    }

    @PostMapping // funciona
    public ResponseEntity<FisioterapiaPacienteDto> guardar(@RequestBody FisioterapiaPaciente fisioterapiaPaciente){
        return new ResponseEntity<>(service.guardar(fisioterapiaPaciente), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<FisioterapiaPacienteDto> actualizar(@RequestBody FisioterapiaPaciente fisioterapiaPaciente){
        return ResponseEntity.ok(service.actualizar(fisioterapiaPaciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Fisioterapia para paciente borrada",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/paciente")
    public ResponseEntity<FisioterapiaPacienteDto> modificarPaciente(@PathVariable Long id,
                                                                     @RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                     @RequestParam String opcion){
        return ResponseEntity.ok(service.modificarPaciente(id, pacienteIdODni, opcion));
    }

    @PatchMapping("/{id}/fecha-inicio")
    public ResponseEntity<FisioterapiaPacienteDto> modificarFechaDeInicio(@PathVariable Long id,
                                                                          @RequestParam LocalDate inicio){
        return ResponseEntity.ok(service.modificarFechaDeInicio(id, inicio));
    }

    @PatchMapping("/{id}/fecha-final")
    public ResponseEntity<FisioterapiaPacienteDto> modificarFechaDeFinal(@PathVariable Long id,
                                                                         @RequestParam LocalDate fin){
        return ResponseEntity.ok(service.modificareFechaDeFinal(id, fin));
    }
}

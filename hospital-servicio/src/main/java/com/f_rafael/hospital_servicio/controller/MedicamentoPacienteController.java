package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.dto.MedicamentoPacienteDto;
import com.f_rafael.hospital_servicio.model.MedicamentoPaciente;
import com.f_rafael.hospital_servicio.service.IMedicamentoPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/medicamentos-pacientes")
public class MedicamentoPacienteController {

    private IMedicamentoPacienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoPacienteDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoPacienteDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/paciente")
    public ResponseEntity<List<MedicamentoPacienteDto>> buscarPorPaciente(@RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                          @RequestParam String opcion){
        return ResponseEntity.ok(service.buscarPorPaciente(pacienteIdODni, opcion));
    }

    @GetMapping("/principio-activo")
    public ResponseEntity<List<MedicamentoPacienteDto>> buscarPorPrincipioActivo(@RequestParam String principioActivo){
        return ResponseEntity.ok(service.buscarPorPrincipioActivo(principioActivo));
    }

    @GetMapping("/fecha-inicio")
    public ResponseEntity<List<MedicamentoPacienteDto>> buscarPorFechaDeInicio(@RequestParam LocalDate desde,
                                                                               @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorFechaDeInicio(desde, hasta));
    }

    @GetMapping("/fecha-final")
    public ResponseEntity<List<MedicamentoPacienteDto>> buscarPorFechaDeFinal(@RequestParam LocalDate desde,
                                                                              @RequestParam LocalDate hasta){
        return ResponseEntity.ok(service.buscarPorFechaDeFinal(desde, hasta));
    }

    @PostMapping
    public ResponseEntity<MedicamentoPacienteDto> guardar(@RequestBody MedicamentoPaciente medicamentoPaciente){
        return new ResponseEntity<>(service.guardar(medicamentoPaciente), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<MedicamentoPacienteDto> actualizar(@RequestBody MedicamentoPaciente medicamentoPaciente){
        return ResponseEntity.ok(service.actualizar(medicamentoPaciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("El tratamiento ha sido  borrado",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/paciente")
    public ResponseEntity<MedicamentoPacienteDto> modificarPaciente(@PathVariable Long id,
                                                                    @RequestParam("paciente-id-o-dni") Long pacienteIdODni,
                                                                    @RequestParam String opcion){
        return ResponseEntity.ok(service.modificarPaciente(id,pacienteIdODni,opcion));
    }

    @PatchMapping("/{id}/medicamento")
    public ResponseEntity<MedicamentoPacienteDto> modificarMedicamento(@PathVariable Long id,
                                                                       @RequestParam("medicamento-id") Long medicamentoId){
        return ResponseEntity.ok(service.modificarMedicamento(id, medicamentoId));
    }

    @PatchMapping("/{id}/dosis")
    public ResponseEntity<MedicamentoPacienteDto> modificarDosis(@PathVariable Long id,
                                                                 @RequestParam("dosis-id") Long dosisId){
        return ResponseEntity.ok(service.modificarDosis(id, dosisId));
    }

    @PatchMapping("/{id}/fecha-inicio")
    public ResponseEntity<MedicamentoPacienteDto> modificarFechaDeInicio(@PathVariable Long id,
                                                                         @RequestParam LocalDate inicio){
        return ResponseEntity.ok(service.modificarFechaDeInicio(id, inicio));
    }

    @PatchMapping("/{id}/fecha-final")
    public ResponseEntity<MedicamentoPacienteDto> modificarFechaDeFinal(@PathVariable Long id,
                                                                        @RequestParam LocalDate fin){
        return ResponseEntity.ok(service.modificarFechaDeFinal(id, fin));
    }
}

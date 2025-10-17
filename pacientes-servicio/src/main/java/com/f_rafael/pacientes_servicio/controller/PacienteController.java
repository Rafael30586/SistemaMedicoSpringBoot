package com.f_rafael.pacientes_servicio.controller;

import com.f_rafael.pacientes_servicio.dto.PacienteDto;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.service.IPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@AllArgsConstructor
public class PacienteController {

    private IPacienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<PacienteDto> buscarPorDni(@RequestParam Long dni){
        return ResponseEntity.ok(service.buscarPorDni(dni));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorApellido(@RequestParam String apellido){
        return ResponseEntity.ok(service.buscarPorApellido(apellido));
    }

    @GetMapping
    public ResponseEntity<PacienteDto> buscarPorEmail(@RequestParam String email){
        return ResponseEntity.ok(service.buscarPorEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorTelefono(@RequestParam("numero-telefonico") String numeroTelefonico){
        return ResponseEntity.ok(service.buscarPorNumeroTelefonico(numeroTelefonico));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorIntervaloNacimiento(@RequestParam Integer desde,
                                                                    @RequestParam Integer hasta){
        return ResponseEntity.ok(service.buscarPorIntervaloNacimiento(desde,hasta));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorLugarNacimiento(@RequestParam String localidad){
        return ResponseEntity.ok(service.buscarPorLugarNacimiento(localidad));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorDomicilio(@RequestParam String calle){
        return ResponseEntity.ok(service.buscarPorDomicilio(calle));
    }

    @PostMapping
    public ResponseEntity<PacienteDto> guardar(@RequestBody Paciente paciente){
        return new ResponseEntity<>(service.guardar(paciente), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<PacienteDto> actualizar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(service.actualizar(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }
}

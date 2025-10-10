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

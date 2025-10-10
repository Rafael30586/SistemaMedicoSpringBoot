package com.f_rafael.pacientes_servicio.controller;

import com.f_rafael.pacientes_servicio.dto.ResultadoDeEstudiosDto;
import com.f_rafael.pacientes_servicio.model.ResultadosDeEstudios;
import com.f_rafael.pacientes_servicio.service.IResultadosDeEstudiosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultados-de-estudios")
@AllArgsConstructor
public class ResultadosDeEstudiosController {

    private IResultadosDeEstudiosService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoDeEstudiosDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ResultadoDeEstudiosDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscartodos());
    }

    @PostMapping
    public ResponseEntity<ResultadoDeEstudiosDto> guardar(@RequestBody ResultadosDeEstudios resultadosDeEstudios){
        return new ResponseEntity<>(service.guardar(resultadosDeEstudios), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<ResultadoDeEstudiosDto> actualizar(@RequestBody ResultadosDeEstudios resultadosDeEstudios){
        return ResponseEntity.ok(service.actualizar(resultadosDeEstudios));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }
}

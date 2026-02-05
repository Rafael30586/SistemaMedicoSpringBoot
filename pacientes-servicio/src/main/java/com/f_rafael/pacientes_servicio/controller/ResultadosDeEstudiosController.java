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

    @GetMapping("/{id}") // funciona
    public ResponseEntity<ResultadoDeEstudiosDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<ResultadoDeEstudiosDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscartodos());
    }

    @GetMapping("/paciente") // funciona
    public ResponseEntity<List<ResultadoDeEstudiosDto>> buscarPorPaciente(@RequestParam Long dni){
        return ResponseEntity.ok(service.buscarPorPaciente(dni));
    }

    @GetMapping("/estudio") // funciona
    public ResponseEntity<List<ResultadoDeEstudiosDto>> buscarPorEstudio(@RequestParam("nombre-estudio") String nombreEstudio){
        return ResponseEntity.ok(service.buscarPorEstudio(nombreEstudio));
    }

    @PostMapping // funciona
    public ResponseEntity<ResultadoDeEstudiosDto> guardar(@RequestBody ResultadosDeEstudios resultadosDeEstudios){
        return new ResponseEntity<>(service.guardar(resultadosDeEstudios), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<ResultadoDeEstudiosDto> actualizar(@RequestBody ResultadosDeEstudios resultadosDeEstudios){
        return ResponseEntity.ok(service.actualizar(resultadosDeEstudios));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/paciente") // funciona
    public ResponseEntity<ResultadoDeEstudiosDto> actualizarPaciente(@PathVariable Long id,
                                                                     @RequestParam("id-o-dni-paciente") Long idODniPaciente,
                                                                     @RequestParam String opcion){
        return ResponseEntity.ok(service.actualizarPaciente(id,idODniPaciente,opcion));
    }

    @PatchMapping("/{id}/agregar-estudio") // funciona
    public ResponseEntity<ResultadoDeEstudiosDto> agregarEstudio(@PathVariable Long id,
                                                                 @RequestParam("estudio-id") Long estudioId){
        return ResponseEntity.ok(service.agregarEstudio(id,estudioId));
    }

    @PatchMapping("/{id}/quitar-estudio") // funciona
    public ResponseEntity<ResultadoDeEstudiosDto> quitarEstudio(@PathVariable Long id,
                                                                @RequestParam("estudio-id") Long estudioId){
        return ResponseEntity.ok(service.quitarEstudio(id,estudioId));
    }

    @PatchMapping("/{id}/url-informe") // funciona
    public ResponseEntity<ResultadoDeEstudiosDto> actualizarUrlInforme(@PathVariable Long id,
                                                                       @RequestParam("url-informe") String urlInforme){
        return ResponseEntity.ok(service.actualizarUrlInforme(id,urlInforme));
    }
}

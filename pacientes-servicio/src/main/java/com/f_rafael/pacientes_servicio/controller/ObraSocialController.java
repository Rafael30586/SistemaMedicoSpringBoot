package com.f_rafael.pacientes_servicio.controller;

import com.f_rafael.pacientes_servicio.dto.ObraSocialDto;
import com.f_rafael.pacientes_servicio.model.ObraSocial;
import com.f_rafael.pacientes_servicio.service.IObraSocialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras-sociales")
@AllArgsConstructor
public class ObraSocialController {

    private IObraSocialService service;

    @GetMapping("/{id}")
    public ResponseEntity<ObraSocialDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ObraSocialDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping
    public ResponseEntity<ObraSocialDto> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @PostMapping
    public ResponseEntity<ObraSocialDto> guardar(@RequestBody ObraSocial obraSocial){
        return new ResponseEntity<>(service.guardar(obraSocial), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<ObraSocialDto> actualizar(@RequestBody ObraSocial obraSocial){
        return ResponseEntity.ok(service.actualizar(obraSocial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ObraSocialDto> actualizarNombre(@PathVariable Long id, @RequestParam String nombre){
        return ResponseEntity.ok(service.actualizarNombre(id,nombre));
    }
    
}

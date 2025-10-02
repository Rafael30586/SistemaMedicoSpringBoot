package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.service.IAccionTerapeuticaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acciones-terapeuteicas")
@AllArgsConstructor
public class AccionTerapeuticaController {

    private IAccionTerapeuticaService service;

    @GetMapping("/{id}")
    public ResponseEntity<AccionTerapeuticaDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<AccionTerapeuticaDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping
    public ResponseEntity<AccionTerapeuticaDto> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre2(nombre));
    }

    @GetMapping
    public ResponseEntity<List<AccionTerapeuticaDto>> buscarPorSecuenciaEnDescripcion(@RequestParam String secuencia){
        return ResponseEntity.ok(service.buscarPorSecuenciaEnDescripcion2(secuencia));
    }

    @PostMapping
    public ResponseEntity<AccionTerapeuticaDto> guardar(@RequestBody AccionTerapeutica accionTerapeutica){
        return new ResponseEntity<>(service.guardar2(accionTerapeutica),HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<AccionTerapeuticaDto> actualizar(@RequestBody AccionTerapeutica accionTerapeutica){
        return ResponseEntity.ok(service.actualizar2(accionTerapeutica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId2(id);
        return new ResponseEntity<>("Entidad borrada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> modificarNombre(@PathVariable Long id, @RequestParam String nombre){
        service.modificarNombre(id,nombre);
        return new ResponseEntity<>("Entidad modificada correctamente",HttpStatusCode.valueOf(204));
    }
}

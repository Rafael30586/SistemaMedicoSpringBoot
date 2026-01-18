package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.model.EstudioMedicoClasificacion;
import com.f_rafael.hospital_servicio.service.IEstudioMedicoClasificacionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clasificacion-estudios-medicos")
@AllArgsConstructor
public class EstudioMedicoClasificacionController {

    private IEstudioMedicoClasificacionService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<EstudioMedicoClasificacion> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<EstudioMedicoClasificacion>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<EstudioMedicoClasificacion> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @PostMapping // funciona
    public ResponseEntity<EstudioMedicoClasificacion> guardar(@RequestBody EstudioMedicoClasificacion clasificacion){
        return new ResponseEntity<>(service.guardar(clasificacion), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<EstudioMedicoClasificacion> actualizar(@RequestBody EstudioMedicoClasificacion clasificacion){
        return ResponseEntity.ok(service.actualizar(clasificacion));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("La clasificación ha sido guardada",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/nombre") // funciona
    public ResponseEntity<EstudioMedicoClasificacion> modificarNombre(@PathVariable Long id,
                                                                      @RequestParam String nombre){
        return ResponseEntity.ok(service.modificarNombre(id, nombre));
    }
}

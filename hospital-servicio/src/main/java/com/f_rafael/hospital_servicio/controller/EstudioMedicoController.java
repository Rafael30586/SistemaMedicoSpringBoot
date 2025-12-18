package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.model.EstudioMedico;
import com.f_rafael.hospital_servicio.service.IEstudioMedicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios-medicos")
@AllArgsConstructor
public class EstudioMedicoController {

    private IEstudioMedicoService service;

    @GetMapping("/{id}")
    public ResponseEntity<EstudioMedico> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<EstudioMedico>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/nombre")
    public ResponseEntity<EstudioMedico> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping("/clasificacion")
    public ResponseEntity<List<EstudioMedico>> buscarPorClasificacion(@RequestParam String clasificacion){
        return ResponseEntity.ok(service.buscarPorClasificacion(clasificacion));
    }

    @PostMapping
    public ResponseEntity<EstudioMedico> guardar(@RequestBody EstudioMedico estudioMedico){
        return new ResponseEntity<>(service.guardar(estudioMedico), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<EstudioMedico> actualizar(@RequestBody EstudioMedico estudioMedico){
        return ResponseEntity.ok(service.actualizar(estudioMedico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Estudio médico borrado", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/nombre")
    public ResponseEntity<EstudioMedico> modificarNombre(@PathVariable Long id,
                                                         @RequestParam String nombre){
        return ResponseEntity.ok(service.modificarNombre(id, nombre));
    }

    @PatchMapping("/{id}/clasificacion")
    public ResponseEntity<EstudioMedico> modificarClasificacion(@PathVariable Long id,
                                                                @RequestParam("id-clasificacion") Long idClasificacion){
        return ResponseEntity.ok(service.modificarClasificacion(id, idClasificacion));
    }
}

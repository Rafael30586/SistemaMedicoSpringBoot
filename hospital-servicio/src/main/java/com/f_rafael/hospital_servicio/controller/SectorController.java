package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.model.Sector;
import com.f_rafael.hospital_servicio.service.ISectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sectores")
@AllArgsConstructor
public class SectorController {

    private ISectorService service;

    @GetMapping("/{id}")
    public ResponseEntity<Sector> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Sector>> buscartodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/nombre")
    public ResponseEntity<Sector> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @PostMapping
    public ResponseEntity<Sector> guardar(@RequestBody Sector sector){
        return new ResponseEntity<>(service.guardar(sector), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<Sector> actualizar(@RequestBody Sector sector){
        return ResponseEntity.ok(service.actualizar(sector));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("El sector ha sido borrado",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/nombre")
    public ResponseEntity<Sector> modificarNombre(@PathVariable Long id,
                                                  @RequestParam String nombre){
        return ResponseEntity.ok(service.modificarNombre(id, nombre));
    }

}

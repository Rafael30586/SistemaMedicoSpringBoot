package com.f_rafael.lugares_servicio.controller;

import com.f_rafael.lugares_servicio.model.Provincia;
import com.f_rafael.lugares_servicio.service.IProvinciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/provincias")
public class ProvinciaController {

    private IProvinciaService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<Provincia> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<Provincia>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<Provincia> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @PostMapping // funciona
    public ResponseEntity<Provincia> guardar(@RequestBody Provincia provincia){
        return new ResponseEntity<>(service.guardar(provincia),HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<Provincia> actualizar(@RequestBody Provincia provincia){
        return ResponseEntity.ok(service.actualizar(provincia));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/nombre") // funciona
    public ResponseEntity<Provincia> modificarNombre(@PathVariable Long id,@RequestParam String nombre){
        return ResponseEntity.ok(service.modificarNombre(id, nombre));
    }

    @PatchMapping("/{id}/pais") // funciona
    public ResponseEntity<Provincia> modificarPais(@PathVariable Long id,@RequestParam("pais-id") Long paisId){
        return ResponseEntity.ok(service.modificarProvincia(id, paisId));
    }

}

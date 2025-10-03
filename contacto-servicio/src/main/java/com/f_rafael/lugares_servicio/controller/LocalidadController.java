package com.f_rafael.lugares_servicio.controller;

import com.f_rafael.lugares_servicio.model.Localidad;
import com.f_rafael.lugares_servicio.service.ILocalidadService;
import com.f_rafael.lugares_servicio.utils.Transform;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidades")
@AllArgsConstructor
public class LocalidadController {

    private ILocalidadService service;

    @GetMapping("/{id}")
    public ResponseEntity<Localidad> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Localidad>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @PostMapping
    public ResponseEntity<Localidad> guardar(@RequestBody Localidad localidad){
        return new ResponseEntity<>(service.guardar(localidad),HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<Localidad> actualizar(@RequestBody Localidad localidad){
        return ResponseEntity.ok(service.actualizar(localidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada corrctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> modificarNombre(@PathVariable Long id,@RequestParam String nombre){
        String nombreSinGuiones = Transform.removerGuiones(nombre);
        service.cambiarNombre(id,nombreSinGuiones);
        return new ResponseEntity<>("Entidad modificada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> modificarProvincia(@PathVariable Long id,
                                                     @RequestParam("provincia-id") Long provinciaId){
        service.cambiarProvincia(id,provinciaId);
        return new ResponseEntity<>("Entidad modificada correctamente", HttpStatusCode.valueOf(204));
    }
}

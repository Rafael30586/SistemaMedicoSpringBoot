package com.f_rafael.lugares_servicio.controller;

import com.f_rafael.lugares_servicio.model.Localidad;
import com.f_rafael.lugares_servicio.service.ILocalidadService;
import lombok.AllArgsConstructor;
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

        if(service.buscarPorId(id).isPresent()){
            return ResponseEntity.ok(service.buscarPorId(id).get());
        }else{
            return ResponseEntity.ok(new Localidad(-9999L,null,null));
        }

    }
    @GetMapping
    public ResponseEntity<List<Localidad>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @PostMapping
    public ResponseEntity<Localidad> guardar(@RequestBody Localidad localidad){
        return ResponseEntity.ok(service.guardar(localidad));
    }

    @PutMapping
    public ResponseEntity<Localidad> actualizar(@RequestBody Localidad localidad){
        Long id = localidad.getId();
        if(id == null){
            return ResponseEntity.ok(new Localidad(-9999999L,"El id no puede ser nulo",null));
        }

        if(service.buscarPorId(id).isPresent()){
            return ResponseEntity.ok(service.actualizar(localidad));
        }else{
            return ResponseEntity.ok(new Localidad(-99999L,"Entidad no encontrada",null));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isPresent()){
            service.borrarPorId(id);
            return ResponseEntity.ok("Entidad borrada correctamente");
        }else{
            return ResponseEntity.ok("Entidad no encontrada");
        }

    }
}

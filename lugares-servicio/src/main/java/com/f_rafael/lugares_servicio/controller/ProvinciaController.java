package com.f_rafael.lugares_servicio.controller;

import com.f_rafael.lugares_servicio.model.Provincia;
import com.f_rafael.lugares_servicio.service.IProvinciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/provincias")
public class ProvinciaController {

    private IProvinciaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Provincia> buscarPorId(@PathVariable Long id){
        if(service.buscarPorId(id).isPresent()){
            return ResponseEntity.ok(service.buscarPorId(id).get());
        }else{
            return ResponseEntity.ok(new Provincia(-99999999L,"Entidad no encontrada"));
        }
    }

    @GetMapping
    public ResponseEntity<List<Provincia>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @PostMapping
    public ResponseEntity<Provincia> guardar(@RequestBody Provincia provincia){
        return ResponseEntity.ok(service.guardar(provincia));
    }

    @PutMapping
    public ResponseEntity<Provincia> actualizar(@RequestBody Provincia provincia){
        Long id = provincia.getId();

        if(id == null){
            return ResponseEntity.ok(new Provincia(-99999999L,"El id no puede ser nulo"));
        }

        if(service.buscarPorId(id).isPresent()){
            return ResponseEntity.ok(service.actualizar(provincia));
        }else{
            return ResponseEntity.ok(new Provincia(-999999L,"Entidad no encontrada"));
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
